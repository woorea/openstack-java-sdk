package com.woorea.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.utils.ConsoleUtils;
import com.woorea.openstack.keystone.Keystone;

public class KeystoneTenantDelete extends KeystoneCommand {
	
	public KeystoneTenantDelete() {
		super("tenant-delete");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			keystone.tenants().delete(args[0]).execute();
			System.out.println(new ConsoleUtils().green("OK"));
		}
		
	}
	
}
