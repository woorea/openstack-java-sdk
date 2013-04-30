package org.openstack.console.nova;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.nova.Nova;


public abstract class NovaCommand extends Command {
	
	public NovaCommand(String name) {
		super(name);
	}

	@Override
	public void execute(Console console, CommandLine args) {
		NovaEnvironment environment = (NovaEnvironment) console.getEnvironment();
		execute(environment.CLIENT, args);
		
	}

	protected abstract void execute(Nova nova, CommandLine args);

}
