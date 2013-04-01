package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.keystone.KeystoneClient;

public abstract class KeystoneCommand extends Command {
	
	public KeystoneCommand(String name) {
		super(name);
	}

	@Override
	public void execute(Console console, CommandLine args) {
		KeystoneEnvironment environment = (KeystoneEnvironment) console.getEnvironment();
		execute(environment.CLIENT, args);
		
	}

	protected abstract void execute(KeystoneClient keystone, CommandLine args);

}
