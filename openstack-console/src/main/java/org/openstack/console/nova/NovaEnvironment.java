package org.openstack.console.nova;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.console.Environment;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.nova.NovaClient;

public class NovaEnvironment extends Environment {
	
	public final NovaClient CLIENT;
	
	public static final Command NOVA = new Command("nova") {
		
		@Override
		public void execute(Console console, CommandLine args) {
			
			if(args.getArgs().length == 1) {
				KeystoneClient keystone = new KeystoneClient((String) console.getProperty("keystone.endpoint"));
				
				Access access = keystone.execute(Authenticate.withPasswordCredentials(
						(String) console.getProperty("keystone.username"), 
						(String) console.getProperty("keystone.password")
				).withTenantName((String) console.getProperty("keystone.tenant_name")));
								
				NovaClient client = new NovaClient("http://compute.stacksherpa.org/v2/"+args.getArgs()[0]);
				client.token(access.getToken().getId());
				
				NovaEnvironment environment = new NovaEnvironment(console.getEnvironment(), client);
				
				environment.register(new NovaServerList());
				
				console.setEnvironment(environment);
					
			}
			
		}
		
	};
	
	public NovaEnvironment(Environment parent, NovaClient client) {
		super(parent);
		CLIENT = client;
	}

	/* (non-Javadoc)
	 * @see org.woorea.wsh.Environment#getPrompt()
	 */
	@Override
	public String getPrompt() {
		return "nova> ";
	}
	
}
