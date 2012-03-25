package org.openstack.console.commands;

import org.openstack.console.common.commands.AutoComplete;
import org.openstack.console.common.commands.CommandRegistryBase;

public class OpenstackCliCommandRegistry extends CommandRegistryBase {
    public OpenstackCliCommandRegistry() {
        addCommand(new AutoComplete());
        discoverCommands(getClass().getPackage());
    }
}
