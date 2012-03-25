package org.openstack.console.common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.openstack.console.common.output.OutputSink;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

public class CliBase {
    static CliHandler handler;

    protected static void init(CliHandler handler) {
        CliBase.handler = handler;
    }

    static void printError(String message) {
        printError(message, null);
    }

    static void printError(String message, Exception e) {
        System.err.println(message);
        if (e != null) {
            e.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        int returnCode;
        returnCode = mainWithReturnCode(args, false);
        System.exit(returnCode);
    }

    private static int mainWithReturnCode(String[] args, boolean isServer) {
        int retcode = 0;

        CliOptions options = handler.buildOptionsBean();
        options.setServerMode(isServer);

        CmdLineParser parser = new CmdLineParser(options);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            // Message is pre-formatted for us
            printError(e.getMessage());
            printHelp(parser);
            return 1;
        }

        if (options.showHelp) {
            printHelp(parser);
            return 0;
        }

        Repl repl = null;
        try {
            CliContext context;
            try {
                context = handler.buildContext(options);
            } catch (Exception e) {
                printError("Error configuring context", e);
                return 2;
            }

            CliContextBase.setThreadLocal(context);

            try {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, Charsets.UTF_8));
                OutputSink outputSink = options.format.buildOutputSink(context, out);

                PrintWriter err = new PrintWriter(new OutputStreamWriter(System.err, Charsets.UTF_8));

                ShellType shellType = options.shellType;

                switch (shellType) {
                case Python:
                    repl = new CliPythonRepl(outputSink, err, context);
                    break;
                default:
                    repl = new CliSimpleRepl(outputSink, err, context);
                    break;
                }
            } catch (IOException e) {
                printError("Error configuring console", e);
                return 2;
            }

            try {
                context.connect();
            } catch (Exception e) {
                printError("Error connecting", e);
                System.exit(3);
            }

            if (!options.arguments.isEmpty()) {
                if (!repl.runCommand(options.arguments))
                    retcode = 1;
            } else {
                repl.runRepl();
            }
        } catch (Exception e) {
            printError("Unexpected error", e);
            return 2;
        } finally {
            IOUtils.closeQuietly(repl);

            CliContextBase.setThreadLocal(null);
        }

        return retcode;
    }

    private static void printHelp(CmdLineParser parser) {
        parser.printUsage(System.err);
    }

}
