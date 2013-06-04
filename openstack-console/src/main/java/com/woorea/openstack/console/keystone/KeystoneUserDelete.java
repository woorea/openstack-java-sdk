package com.woorea.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.utils.ConsoleUtils;
import com.woorea.openstack.keystone.Keystone;

public class KeystoneUserDelete extends KeystoneCommand {
	
	public KeystoneUserDelete() {
		super("user-delete");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			keystone.users().delete(args[0]).execute();
			System.out.println(new ConsoleUtils().green("OK"));
		}
		
	}
	
}
