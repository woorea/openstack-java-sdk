package com.woorea.openstack.console;
import java.util.Map;
import java.util.TreeMap;


public class Environment {

	protected final Environment parent;
	
	protected Map<String, Command> commands = new TreeMap<String, Command>();
	
	public Environment(Environment parent) {
		register(Commands.EXIT);
		register(Commands.SET);
		this.parent = parent;
	}
	
	public Environment() {
		this(null);
	}

	public void register(Command command) {
		commands.put(command.name, command);
	}

	public String getPrompt() {
		return "> ";
	}

}
