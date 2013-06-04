package com.woorea.openstack.console;

import java.util.Map;

import org.apache.commons.cli.CommandLine;

public class Commands {

	public static final Command EXIT = new Command("exit") {

		@Override
		public void execute(Console console, CommandLine args) {
			console.exit();
		}
		
	};
	
	public static final Command SET = new Command("set") {

		@Override
		public void execute(Console console, CommandLine args) {
			if(args.getArgs().length == 2) {
				console.setProperty(args.getArgs()[0], args.getArgs()[1]);
			} else {
				console.properties();
			}
		}
		
	};

}
