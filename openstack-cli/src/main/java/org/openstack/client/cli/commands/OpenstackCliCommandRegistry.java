package org.openstack.client.cli.commands;

import com.fathomdb.cli.commands.AutoComplete;
import com.fathomdb.cli.commands.CommandRegistryBase;

public class OpenstackCliCommandRegistry extends CommandRegistryBase {
    public OpenstackCliCommandRegistry() {
        addCommand(new AutoComplete());
        discoverCommands(getClass().getPackage());
    }
}
