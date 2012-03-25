package org.openstack.console.common;

import org.openstack.console.common.commands.CommandRegistry;
import org.openstack.console.common.formatter.FormatterRegistry;


public interface CliContext {

    CommandRegistry getCommandRegistry();

    FormatterRegistry getFormatterRegistry();

    void connect() throws Exception;

}
