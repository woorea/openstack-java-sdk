package org.openstack.console.nova;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.console.utils.Environment;
import org.openstack.nova.NovaClient;

public class NovaEnvironment extends Environment {
	
	public NovaEnvironment(Console console) {
		
		super(console);
		
		/*
		KeystoneClient client = new KeystoneClient((String) properties.get("keystone.endpoint"));
		
		Access access = client.execute(Authenticate.withPasswordCredentials(
				(String) properties.get("keystone.username"), 
				(String) properties.get("keystone.password")
		).withTenantName((String) properties.get("keystone.tenant_name")));
				
		client.token(access.getToken().getId());
		*/
		
		NovaClient client = new NovaClient((String) console.getProperty("compute.endpoint"));
		
		add(new NovaServerList(client));
	
	}
	
	/* (non-Javadoc)
	 * @see org.openstack.console.utils.Environment#getPrompt()
	 */
	@Override
	public String getPrompt() {
		return new ConsoleUtils().green("nova> ").toString();
	}



	public static Command command() {
		
		return new Command("nova") {
			
			@Override
			public void execute(Console console, CommandLine cmd) {
				console.setEnvironment(new NovaEnvironment(console));
				
			}
		};
	}
	
}
