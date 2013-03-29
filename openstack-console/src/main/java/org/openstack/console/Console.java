package org.openstack.console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import jline.console.ConsoleReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.console.utils.Environment;

import com.google.common.collect.ImmutableMap;

public class Console {
	
	private ConsoleReader consoleReader;
	
	private Environment environment;
	
	protected Map<String, Object> properties = new HashMap<String, Object>();

	public void init() {
		
		properties.put("console.logging", Boolean.TRUE);
		properties.put("keystone.endpoint", "http://keystone/v2.0");
		properties.put("keystone.username", "admin");
		properties.put("keystone.password", "secret0");
		properties.put("keystone.tenant_name", "admin");
		properties.put("identity.endpoint", "http://identity/v2.0");
		
		try {
			HelpFormatter helpFormatter = new HelpFormatter();
			CommandLineParser commandLineParser = new GnuParser();
			consoleReader = new ConsoleReader();
			//consoleReader.setHandleUserInterrupt(true);
			setEnvironment(new OpenStackEnvironment(this));
			String input = consoleReader.readLine(getPrompt());
			while(input != null) {
				String[] cmd = parse(input);
				if(cmd.length > 0) {
					Command command = environment.command(cmd[0]);
					if(command != null) {
						try {
							CommandLine commandLine = commandLineParser.parse(command.getOptions(), Arrays.copyOfRange(cmd, 1, cmd.length));
							command.call(this,commandLine);
						} catch (Exception e) {
							helpFormatter.printHelp(command.getName(), command.getOptions());
							e.printStackTrace();
							//Console.red(e.getMessage());
						}
					}
				}
				input = consoleReader.readLine(getPrompt());
			}
		} catch (Exception e) {
			e.printStackTrace();
			//HelpFormatter formatter = new HelpFormatter();
			//formatter.printHelp("myapp", header, options, footer, true);
		}
	}
	
	public static String[] parse(String input) {
        if (input == null || input.length() == 0) {
            //no command? no string
            return new String[0];
        }
        // parse with a simple finite state machine

        final int normal = 0;
        final int inQuote = 1;
        final int inDoubleQuote = 2;
        int state = normal;
        StringTokenizer tok = new StringTokenizer(input, "\"\' ", true);
        Vector v = new Vector();
        StringBuffer current = new StringBuffer();
        boolean lastTokenHasBeenQuoted = false;

        while (tok.hasMoreTokens()) {
            String nextTok = tok.nextToken();
            switch (state) {
            case inQuote:
                if ("\'".equals(nextTok)) {
                    lastTokenHasBeenQuoted = true;
                    state = normal;
                } else {
                    current.append(nextTok);
                }
                break;
            case inDoubleQuote:
                if ("\"".equals(nextTok)) {
                    lastTokenHasBeenQuoted = true;
                    state = normal;
                } else {
                    current.append(nextTok);
                }
                break;
            default:
                if ("\'".equals(nextTok)) {
                    state = inQuote;
                } else if ("\"".equals(nextTok)) {
                    state = inDoubleQuote;
                } else if (" ".equals(nextTok)) {
                    if (lastTokenHasBeenQuoted || current.length() != 0) {
                        v.addElement(current.toString());
                        current = new StringBuffer();
                    }
                } else {
                    current.append(nextTok);
                }
                lastTokenHasBeenQuoted = false;
                break;
            }
        }
        if (lastTokenHasBeenQuoted || current.length() != 0) {
            v.addElement(current.toString());
        }
        if (state == inQuote || state == inDoubleQuote) {
            throw new RuntimeException("unbalanced quotes in " + input);
        }
        String[] args = new String[v.size()];
        v.copyInto(args);
        return args;
    }

	public void setEnvironment(Environment environment) {
		if(this.environment != null) {
			System.out.println(consoleReader.removeCompleter(consoleReader.getCompleters().iterator().next()));
		}
		setProperty("console.prompt", environment.getPrompt());
		this.environment = environment;
		consoleReader.addCompleter(environment.completer());
		
	}

	public Environment getEnvironment() {
		return this.environment;
	}
	
	/**
	 * @return the consoleReader
	 */
	public ConsoleReader getConsoleReader() {
		return consoleReader;
	}
	
	public <T> T getProperty(String property) {
		return (T) properties.get(property);
	}
	
	public void setProperty(String property, String value) {
		properties.put(property, value);
	}
	
	public Map<String, Object> getProperties() {
		return ImmutableMap.copyOf(properties);
	}
	
	public String getPrompt() {
		ConsoleUtils console = new ConsoleUtils();
		console.green((String) properties.get("console.prompt"));
		return console.toString();
	}



	private static final Console CONSOLE = new Console();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		CONSOLE.init();
	}
	
}
