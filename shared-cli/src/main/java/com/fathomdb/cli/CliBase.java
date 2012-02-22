package com.fathomdb.cli;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.openstack.utils.Io;

import com.fathomdb.cli.output.OutputSink;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.martiansoftware.nailgun.NGContext;
import com.martiansoftware.nailgun.NGServer;

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

        if (args.length == 1 && args[0].startsWith("--listen=")) {
            String portString = args[0].replace("--listen=", "");
            int port = Integer.parseInt(portString);
            returnCode = runListenServer(port);
        } else {
            returnCode = mainWithReturnCode(args, false);
        }
        System.exit(returnCode);
    }

    public static void nailMain(NGContext nailgunContext) {
        List<String> args = Lists.newArrayList(nailgunContext.getArgs());
        for (int i = args.size() - 1; i >= 0; i--) {
            if (args.get(i).equals("")) {
                args.remove(i);
            } else {
                break;
            }
        }

        String[] argsArray = (String[]) args.toArray(new String[args.size()]);
        int returnCode = mainWithReturnCode(argsArray, true);
        System.exit(returnCode);
    }

    private static int runListenServer(int port) {
        InetAddress address = null;

        System.out.println("Listening for connections on " + port);

        NGServer server = new NGServer(address, port);
        server.run();

        return 0;
    }

    private static int mainWithReturnCode(String[] args, boolean isServer) {
        int retcode = 0;

        CliOptions options = handler.buildOptionsBean();
        options.isServer = isServer;

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
            Io.safeClose(repl);

            CliContextBase.setThreadLocal(null);
        }

        return retcode;
    }

    private static void printHelp(CmdLineParser parser) {
        parser.printUsage(System.err);
    }

}
