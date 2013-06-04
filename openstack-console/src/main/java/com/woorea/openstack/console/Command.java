package com.woorea.openstack.console;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;


public abstract class Command {
	
	protected String name;
	
	public Command(String name) {
		this.name = name;
	}

	public abstract void execute(Console console, CommandLine args);
	
	public Options getOptions() {
		return new Options();
	}

}
