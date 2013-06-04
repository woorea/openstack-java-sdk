package com.woorea.openstack.console.nova;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.Command;
import com.woorea.openstack.console.Console;
import com.woorea.openstack.nova.Nova;


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
