package org.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;
import org.openstack.console.Command;
import org.openstack.console.Console;
import org.openstack.console.utils.ConsoleUtils;
import org.openstack.console.utils.Environment;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;

public class KeystoneEnvironment extends Environment {
	
	public KeystoneEnvironment(Console console) {
		
		super(console);
		
		KeystoneClient client = new KeystoneClient((String) console.getProperty("keystone.endpoint"));
		
		Access access = client.execute(Authenticate.withPasswordCredentials(
				(String) console.getProperty("keystone.username"), 
				(String) console.getProperty("keystone.password")
		).withTenantName((String) console.getProperty("keystone.tenant_name")));
				
		client.token(access.getToken().getId());
		
		add(new KeystoneUserList(client));
		add(new KeystoneUserCreate(client));
		add(new KeystoneUserShow(client));
		add(new KeystoneUserDelete(client));
		add(new KeystoneTenantList(client));
		add(new KeystoneTenantCreate(client));
		add(new KeystoneTenantDelete(client));
		add(new KeystoneRoleList(client));
		add(new KeystoneRoleCreate(client));
		add(new KeystoneServiceList(client));
	
	}
	
	/* (non-Javadoc)
	 * @see org.openstack.console.utils.Environment#getPrompt()
	 */
	@Override
	public String getPrompt() {
		return new ConsoleUtils().green("keystone> ").toString();
	}

	public static Command command() {
		
		return new Command("keystone") {
			
			@Override
			public void execute(Console console, CommandLine cmd) {
				console.setEnvironment(new KeystoneEnvironment(console));
				
			}
		};
	}
	
}
