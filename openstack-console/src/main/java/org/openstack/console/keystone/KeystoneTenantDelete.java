package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.keystone.KeystoneClient;

public class KeystoneTenantDelete extends KeystoneCommand {
	
	public KeystoneTenantDelete() {
		super("tenant-delete");
	}

	@Override
	public void execute(KeystoneClient keystone, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			keystone.tenants().delete(args[0]).execute();
			System.out.println(new ConsoleUtils().green("OK"));
		}
		
	}
	
}
