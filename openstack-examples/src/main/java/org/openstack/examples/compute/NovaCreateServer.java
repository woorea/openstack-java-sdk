package org.openstack.examples.compute;

import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.PasswordCredentials;
import org.openstack.keystone.model.Authentication.Token;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;
import org.openstack.nova.NovaClient;
import org.openstack.nova.api.ServersCore;
import org.openstack.nova.api.extensions.KeyPairsExtension;
import org.openstack.nova.api.extensions.SecurityGroupsExtension;
import org.openstack.nova.model.KeyPair;
import org.openstack.nova.model.SecurityGroup;
import org.openstack.nova.model.Server;
import org.openstack.nova.model.ServerForCreate;

public class NovaCreateServer {
	
	private static final String KEYSTONE_AUTH_URL = "";
	
	private static final String KEYSTONE_USERNAME = "";
	
	private static final String KEYSTONE_PASSWORD = "";
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(KEYSTONE_AUTH_URL);		
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(KEYSTONE_USERNAME, KEYSTONE_PASSWORD));
		
		//use the token in the following requests
		keystone.setToken(access.getToken().getId());
		
		Tenants tenants = keystone.execute(new ListTenants());
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantId(tenants.getList().get(0).getId()));
			
			NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());

			//create a new keypair
			KeyPair keyPair = novaClient.execute(KeyPairsExtension.createKeyPair("mykeypair"));
			System.out.println(keyPair.getPrivateKey());
			
			//create security group
			SecurityGroup securityGroup = novaClient.execute(SecurityGroupsExtension.createSecurityGroup("mysecuritygroup", "description"));
			
			novaClient.execute(SecurityGroupsExtension.createSecurityGroupRule(securityGroup.getId(), "UDP", 9090, 9092, "0.0.0.0/0"));
			novaClient.execute(SecurityGroupsExtension.createSecurityGroupRule(securityGroup.getId(), "TCP", 8080, 8080, "0.0.0.0/0"));
			
			ServerForCreate serverForCreate = new ServerForCreate();
			serverForCreate.setName("woorea");
			serverForCreate.setFlavorRef("100");
			serverForCreate.setImageRef("120");
			serverForCreate.setKeyName("woorea");
			serverForCreate.getSecurityGroups().add(new ServerForCreate.SecurityGroup("default"));
			serverForCreate.getSecurityGroups().add(new ServerForCreate.SecurityGroup(securityGroup.getName()));
			
			Server server = novaClient.execute(ServersCore.createServer(serverForCreate));
			System.out.println(server);
			
		} else {
			System.out.println("No tenants found!");
		}
		
	}

}
