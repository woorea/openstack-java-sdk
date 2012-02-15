package com.fathomdb.cli;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class CliOptions {

    @Option(name = "-f", aliases = "--format", usage = "output format")
    public OutputFormat format = OutputFormat.Text;

    @Option(name = "--shell", usage = "shell type")
    public ShellType shellType = ShellType.Simple;

    @Option(name = "-h", aliases = "--help", usage = "displays this help command")
    public boolean showHelp = false;

    @Argument
    public List<String> arguments = new ArrayList<String>();

    public boolean isServer;

}
