package org.openstack.console.common.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openstack.console.common.discovery.Discovery;


import com.google.common.collect.Lists;

public class CommandRegistryBase implements CommandRegistry {
    final Map<String, CommandRunner> registry = new HashMap<String, CommandRunner>();

    public CommandRunner getCommandRunner(String command) {
        return registry.get(command.toLowerCase());
    }

    protected void addCommand(CommandRunner commandRunner) {
        for (CommandSpecifier command : commandRunner.getHandledComands()) {
            for (String commandString : command.getStrings()) {
                registry.put(commandString.toLowerCase(), commandRunner);
            }
        }
    }

    public List<String> listCommands() {
        List<String> commands = Lists.newArrayList();
        for (CommandRunner key : registry.values()) {
            for (CommandSpecifier commandSpecifier : key.getHandledComands()) {
                List<String> commandStrings = commandSpecifier.getStrings();
                // We only add the 'primary' command for now
                String commandString = commandStrings.get(0);
                if (!commands.contains(commandString)) {
                    commands.add(commandString);
                }
            }
        }
        return commands;
    }

    protected void discoverCommands(Package package1) {
        Discovery discovery = new Discovery();
        List<Class<?>> classes = discovery.findClasses(getClass().getPackage());
        List<CommandRunner> instances = discovery.buildInstances(CommandRunner.class, classes);
        for (CommandRunner commandRunner : instances) {
            addCommand(commandRunner);
        }
    }
}
