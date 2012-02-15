package com.fathomdb.cli;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.python.util.InteractiveConsole;
import org.python.util.PythonInterpreter;

import com.fathomdb.cli.output.OutputSink;

public class CliPythonRepl implements Repl {
    final InteractiveConsole jythonInteractiveConsole;

    @Override
    public void runRepl() {
        jythonInteractiveConsole.interact();
    }

    private final CliContext context;
    private final OutputSink outputSink;

    private PrintWriter err;

    public CliPythonRepl(OutputSink outputSink, PrintWriter err, CliContext context) throws IOException {
        this.outputSink = outputSink;
        this.err = err;
        this.context = context;

        if (System.getProperty("python.home") == null) {
            System.setProperty("python.home", "");
        }
        // Why is this a global???
        PythonInterpreter.initialize(System.getProperties(), null, new String[0]);
        jythonInteractiveConsole = new InteractiveConsole();

        // Pull our helper functions into the global namespace
        jythonInteractiveConsole.exec("from org.platformlayer.client.cli.commands.ScriptCommands import *;");

        // from org.openstack.client.cli.commands.ScriptCommands import *

        // reader = new ConsoleReader();
        // reader.setBellEnabled(false);
        // reader.setDebug(new PrintWriter(new FileWriter("writer.debug", true)));

        // reader.addCompletor(new ArgumentCompletor(completors));
    }

    @Override
    public boolean runCommand(List<String> arguments) {
        throw new UnsupportedOperationException();
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

}
