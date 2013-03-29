package org.openstack.console;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.console.utils.Environment;

public class Exit extends Command {
	
	private Environment parent;
	
	public Exit(Environment parent) {
		super("exit");
		this.parent = parent;
	}

	@Override
	public void execute(Console console, final CommandLine cmd) {
		if(parent != null) {
			console.setEnvironment(parent);
		} else {
			ConsoleUtils.log("Goodbye");
			System.exit(0);
		}
	}
}
