package com.fathomdb.cli.commands;

import java.io.PrintWriter;
import java.util.List;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.AutoCompletor;

public interface CommandRunner {
    CommandRunner clone(CliContext context);

    Object runCommand() throws Exception;

    List<CommandSpecifier> getHandledComands();

    void parseArguments(List<String> args) throws Exception;

    void formatRaw(Object o, PrintWriter writer);

    AutoCompletor getAutoCompleter();
}
