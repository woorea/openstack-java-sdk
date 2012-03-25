package com.fathomdb.cli;

import com.fathomdb.cli.commands.CommandRegistry;
import com.fathomdb.cli.formatter.FormatterRegistry;

public interface CliContext {

    CommandRegistry getCommandRegistry();

    FormatterRegistry getFormatterRegistry();

    void connect() throws Exception;

}
