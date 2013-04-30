package org.openstack.console.nova;

import org.apache.commons.cli.CommandLine;
import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.console.Environment;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.nova.Nova;

public class NovaEnvironment extends Environment {
	
	public final Nova CLIENT;
	
	public static final Command NOVA = new Command("nova") {
		
		@Override
		public void execute(Console console, CommandLine args) {
			
			if(args.getArgs().length == 1) {
				Keystone keystone = new Keystone((String) console.getProperty("keystone.endpoint"));
				
				Access access = keystone.execute(Authenticate.withPasswordCredentials(
						console.getProperty("keystone.username"), 
						console.getProperty("keystone.password")
				).withTenantName(console.getProperty("keystone.tenant_name")));
				
				System.out.println(console.getProperty("nova.endpoint"));
				
				Nova client = new Nova(console.getProperty("nova.endpoint")+args.getArgs()[0]);
				client.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
				
				NovaEnvironment environment = new NovaEnvironment(console.getEnvironment(), client);
				
				environment.register(new NovaServerList());
				
				console.setEnvironment(environment);
					
			}
			
		}
		
	};
	
	public NovaEnvironment(Environment parent, Nova client) {
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
