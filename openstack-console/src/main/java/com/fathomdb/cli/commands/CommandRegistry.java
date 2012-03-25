package com.fathomdb.cli.commands;

import java.util.List;

public interface CommandRegistry {

    CommandRunner getCommandRunner(String command);

    List<String> listCommands();

}
