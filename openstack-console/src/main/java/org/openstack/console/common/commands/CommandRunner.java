package org.openstack.console.common.commands;

import java.io.PrintWriter;
import java.util.List;

import org.openstack.console.common.CliContext;
import org.openstack.console.common.autocomplete.AutoCompletor;


public interface CommandRunner {
    CommandRunner clone(CliContext context);

    Object runCommand() throws Exception;

    List<CommandSpecifier> getHandledComands();

    void parseArguments(List<String> args) throws Exception;

    void formatRaw(Object o, PrintWriter writer);

    AutoCompletor getAutoCompleter();
}
