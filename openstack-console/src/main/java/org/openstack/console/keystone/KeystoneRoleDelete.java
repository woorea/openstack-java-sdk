package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.DeleteRole;

public class KeystoneRoleDelete extends KeystoneCommand {
	
	public KeystoneRoleDelete() {
		super("role-delete");
	}

	@Override
	public void execute(KeystoneClient keystone, CommandLine cmd) {
		
		String[] args = cmd.getArgs();
		if(args.length == 1) {
			keystone.execute(new DeleteRole(args[0]));
			System.out.println(new ConsoleUtils().green("OK"));
		}
		
	}
	
}
