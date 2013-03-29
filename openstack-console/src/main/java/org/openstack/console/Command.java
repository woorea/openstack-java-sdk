package org.openstack.console;

import jline.console.completer.Completer;
import jline.console.completer.NullCompleter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openstack.console.utils.ConsoleUtils;

public abstract class Command {
	
	public static final Completer NULL_COMPLETER = new NullCompleter();
	
	protected String name;
	
	public Command(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Options getOptions() {
		return new Options();
	}
	
	public Completer getCompleter() {
		return Command.NULL_COMPLETER;
	}
	
	public void call(Console console, CommandLine cmd) {
		try {
			execute(console, cmd);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(new ConsoleUtils().red(e.getMessage()));
		}
	}

	public abstract void execute(Console console, CommandLine cmd);
	
}