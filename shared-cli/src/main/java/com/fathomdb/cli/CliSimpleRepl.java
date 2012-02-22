package com.fathomdb.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import jline.ConsoleReader;

import org.openstack.utils.Io;

import com.fathomdb.cli.commands.CommandRunner;
import com.fathomdb.cli.output.OutputSink;
import com.fathomdb.cli.output.RawOutputSink;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

class CliSimpleRepl implements Repl {
    private static final String PROMPT = "platformlayer> ";

    private final CliContext context;
    private final OutputSink outputSink;

    private PrintWriter err;
    private ConsoleReader reader;

    public CliSimpleRepl(OutputSink outputSink, PrintWriter err, CliContext context) throws IOException {
        this.outputSink = outputSink;
        this.err = err;
        this.context = context;

        reader = new ConsoleReader();
        reader.setBellEnabled(false);
        // reader.setDebug(new PrintWriter(new FileWriter("writer.debug", true)));

        // reader.addCompletor(new ArgumentCompletor(completors));
    }

    @Override
    public void runRepl() throws IOException {
        // TODO: History
        // reader.setHistory(history)

        String line;
        while ((line = reader.readLine(PROMPT)) != null) {
            if (!doReplLine(line))
                break;

        }
    }

    private boolean doReplLine(String line) {
        line = line.trim();

        if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("\\q")) {
            return false;
        }

        try {
            if (!executeCommand(tokenize(line)))
                return false;
        } catch (Exception e) {
            err.println("Error running command");
            e.printStackTrace(err);
            return false;
        }

        outputSink.flush();
        return true;
    }

    //
    // @Override
    // public void runCommands(List<String> commands) {
    // // TODO: History
    // // reader.setHistory(history)
    //
    // for (String command : commands) {
    // doReplLine(command);
    // }
    // }

    @Override
    public boolean runCommand(List<String> arguments) {
        try {
            if (!executeCommand(arguments))
                return false;
        } catch (Exception e) {
            err.println("Error running command");
            e.printStackTrace(err);
            return false;
        }

        outputSink.flush();

        return true;
    }

    @Override
    public void close() throws IOException {
        // this.client.close();

        if (outputSink != null)
            outputSink.flush();
        if (err != null)
            err.flush();

        // reader.getHistory().setOutput();
    }

    protected boolean executeCommand(List<String> tokens) throws IOException {
        if (tokens.size() == 0)
            return true;

        String verb = tokens.get(0).trim();

        if (verb.length() == 0) {
            return true;
        }

        List<String> args = null;

        if (tokens.size() != 1) {
            args = tokens.subList(1, tokens.size());
        }

        // int spaceIndex = verb.indexOf(' ');
        // if (spaceIndex != -1) {
        // arguments = verb.substring(spaceIndex + 1).trim();
        // verb = verb.substring(0, spaceIndex);
        //
        // if (arguments.length() == 0)
        // arguments = null;
        // }

        CommandRunner commandRunner = context.getCommandRegistry().getCommandRunner(verb);
        if (commandRunner == null) {
            err.println("Unknown command: " + verb + " (line=" + Joiner.on(" ").join(tokens) + ")");
            return false;
        }

        Object results;
        try {
            commandRunner = commandRunner.clone(context);
            if (args != null) {
                commandRunner.parseArguments(args);
            }
            results = commandRunner.runCommand();
        } catch (Exception e) {
            err.println("Error running command: " + Joiner.on(" ").join(tokens));
            e.printStackTrace(err);
            return false;
        }

        if (results != null) {
            outputResults(commandRunner, results);
        }
        return true;
    }

    protected void outputResults(CommandRunner commandRunner, Object results) throws IOException {
        if (outputSink instanceof RawOutputSink) {
            commandRunner.formatRaw(results, ((RawOutputSink) outputSink).getWriter());
        } else {
            if (results instanceof Iterable) {
                for (Object item : (Iterable) results) {
                    outputSink.visitObject(item);
                }
            } else {
                outputSink.visitObject(results);
            }
        }

        outputSink.finishOutput();
        outputSink.flush();
    }

    public boolean runScripts(List<File> scriptFiles) throws IOException {
        for (File scriptFile : scriptFiles) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scriptFile), Charsets.UTF_8));
            try {
                while (true) {
                    String line = reader.readLine();
                    if (line == null)
                        continue;
                    if (line.startsWith("--"))
                        continue;

                    if (line.length() == 0)
                        continue;

                    if (!executeCommand(tokenize(line)))
                        return false;
                }
            } finally {
                Io.safeClose(reader);
            }
        }
        return true;
    }

    private List<String> tokenize(String line) {
        // TODO: Quoting
        List<String> tokens = Lists.newArrayList(line.split(" "));
        return tokens;
    }
}
