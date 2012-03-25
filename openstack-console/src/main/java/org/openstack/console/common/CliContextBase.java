package org.openstack.console.common;

import org.openstack.console.common.commands.CommandRegistry;
import org.openstack.console.common.formatter.FormatterRegistry;


public abstract class CliContextBase implements CliContext {
    final CommandRegistry commandRegistry;
    final FormatterRegistry formatterRegistry;

    public CliContextBase(CommandRegistry commandRegistry, FormatterRegistry formatterRegistry) {
        super();
        this.commandRegistry = commandRegistry;
        this.formatterRegistry = formatterRegistry;
    }

    @Override
    public CommandRegistry getCommandRegistry() {
        return commandRegistry;
    }

    @Override
    public FormatterRegistry getFormatterRegistry() {
        return formatterRegistry;
    }

    @Override
    public void connect() throws Exception {

    }

    static ThreadLocal<CliContext> current = new ThreadLocal<CliContext>();

    public static CliContext get() {
        return current.get();
    }

    public static void setThreadLocal(CliContext context) {
        current.set(context);
    }

}
