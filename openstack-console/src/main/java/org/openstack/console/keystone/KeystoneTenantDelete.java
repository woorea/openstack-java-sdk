package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Console;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.DeleteTenant;

public class KeystoneTenantDelete extends KeystoneCommand {
	
	public KeystoneTenantDelete(KeystoneClient client) {
		super(client, "tenant-delete");
	}

	@Override
	public void execute(Console console, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			keystone.execute(new DeleteTenant(args[0]));
			System.out.println(new ConsoleUtils().green("OK"));
		}
		
	}
	
}
