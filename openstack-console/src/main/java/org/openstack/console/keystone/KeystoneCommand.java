package org.openstack.console.keystone;

import org.openstack.console.Command;
import org.openstack.keystone.KeystoneClient;

public abstract class KeystoneCommand extends Command {
	
	protected KeystoneClient keystone;

	public KeystoneCommand(KeystoneClient client, String name) {
		
		super(name);
		
		this.keystone = client;
	
	}

}
