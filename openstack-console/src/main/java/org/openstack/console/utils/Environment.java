package org.openstack.console.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jline.console.completer.AggregateCompleter;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.Completer;
import jline.console.completer.StringsCompleter;

import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.console.Exit;

public class Environment {

	protected Map<String, Command> commands = new HashMap<String, Command>();
	
	public Environment(Console console) {
		add(new Exit(console != null ? console.getEnvironment() : null));
	}
	
	public Environment() {
		this(null);
	}

	protected void add(Command command) {
		commands.put(command.getName(), command);
	}
	
	

	public Command command(String command) {
		return commands.get(command);
	}
	
	public Completer completer() {
        List<Completer> c = new ArrayList<Completer>();
        for (String cmd : commands.keySet()) {
            List<Completer> cmdCompleters = new ArrayList<Completer>();
            cmdCompleters.add(new StringsCompleter(cmd));
            cmdCompleters.add(commands.get(cmd).getCompleter());
            ArgumentCompleter ac = new ArgumentCompleter(cmdCompleters);
            c.add(ac);
        }
        return new AggregateCompleter(c);
	}
	
	public String getPrompt() {
		return "> ";
	}
	
}
