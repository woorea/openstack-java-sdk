package org.openstack.console.nova;

import org.openstack.console.Command;
import org.openstack.nova.NovaClient;

public abstract class NovaCommand extends Command {
	
	protected NovaClient nova;

	public NovaCommand(NovaClient client, String name) {
		
		super(name);
		
		this.nova = client;
	
	}

}
