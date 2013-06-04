package com.woorea.openstack.console;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jline.UnsupportedTerminal;
import jline.console.ConsoleReader;
import jline.console.completer.Completer;
import jline.console.completer.StringsCompleter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;

public class Console {
	
	private Properties properties;
	
	private ConsoleReader reader;

	private Environment environment;
	
	private HelpFormatter helpFormatter = new HelpFormatter();
	
	private static final CommandLineParser PARSER = new GnuParser();
	
	public Console(Environment environment, Properties properties) {
		this.properties = properties;
		this.environment = environment;
	}
	
	public void start() throws IOException {
		if(System.console() == null) {
			reader = new ConsoleReader(System.in, System.out, new UnsupportedTerminal());
		} else {
			reader = new ConsoleReader();
		}
		do {
			String line = reader.readLine(environment.getPrompt());
			execute(line);
		} while(true);
	}
	
	public void execute(String line) {
		String[] tokens = CommandLineHelper.parse(line);
		if(tokens.length > 0) {
			Command command = environment.commands.get(tokens[0]);
			if(command != null) {
				try {
				CommandLine args = Console.PARSER.parse(command.getOptions(), Arrays.copyOfRange(tokens, 1, tokens.length));
				command.execute(this, args);
				} catch (Exception e) {
					e.printStackTrace();
					helpFormatter.printHelp(command.name, command.getOptions());
				}
			}
		}
	}

	public void setEnvironment(Environment environment) {
		Set<Completer> completers = new HashSet<Completer>(reader.getCompleters());
		for(Completer c : completers) {
			reader.removeCompleter(c);
		}
		Set<String> commands = new HashSet<String>();
		for(Map.Entry<String,Command> c : environment.commands.entrySet()) {
			commands.add(c.getKey());
		}
		reader.addCompleter(new StringsCompleter(commands));
		this.environment = environment;
	}
	
	public Environment getEnvironment() {
		return this.environment;
	}
	
	/**
	 * @return the properties
	 */
	public String getProperty(String name) {
		return properties.getProperty(name);
	}
	
	/**
	 * @return the properties
	 */
	public void setProperty(String name, Object value) {
		properties.put(name, value);
	}
	
	public void properties() {
		for(Map.Entry<Object, Object> entry : properties.entrySet()) {
			System.out.printf("%25s = %55s",entry.getKey(), entry.getValue());
		}
	}

	public void exit() {
		if(environment.parent == null) {
			System.out.println("Goodbye");
			System.exit(1);
		} else {
			environment = environment.parent;
		}
	}

}
