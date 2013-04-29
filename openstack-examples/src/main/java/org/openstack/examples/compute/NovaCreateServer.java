package org.openstack.examples.compute;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.nova.NovaClient;
import org.openstack.nova.api.FlavorsCore;
import org.openstack.nova.api.ImagesCore;
import org.openstack.nova.api.ServersCore;
import org.openstack.nova.api.extensions.KeyPairsExtension;
import org.openstack.nova.model.Flavors;
import org.openstack.nova.model.Images;
import org.openstack.nova.model.KeyPairs;
import org.openstack.nova.model.Server;
import org.openstack.nova.model.ServerForCreate;

public class NovaCreateServer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);		
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));
		
		//use the token in the following requests
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
		
		Tenants tenants = keystone.tenants().list().execute();
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantId(tenants.getList().get(0).getId()));
			
			//NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
			NovaClient novaClient = new NovaClient(ExamplesConfiguration.NOVA_ENDPOINT.concat(tenants.getList().get(0).getId()));
			novaClient.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
			//novaClient.enableLogging(Logger.getLogger("nova"), 100 * 1024);
			//create a new keypair
			//KeyPair keyPair = novaClient.execute(KeyPairsExtension.createKeyPair("mykeypair"));
			//System.out.println(keyPair.getPrivateKey());
			
			//create security group
			//SecurityGroup securityGroup = novaClient.execute(SecurityGroupsExtension.createSecurityGroup("mysecuritygroup", "description"));
			
			//novaClient.execute(SecurityGroupsExtension.createSecurityGroupRule(securityGroup.getId(), "UDP", 9090, 9092, "0.0.0.0/0"));
			//novaClient.execute(SecurityGroupsExtension.createSecurityGroupRule(securityGroup.getId(), "TCP", 8080, 8080, "0.0.0.0/0"));
			
			KeyPairs keysPairs = novaClient.execute(KeyPairsExtension.listKeyPairs());
			
			Images images = novaClient.execute(ImagesCore.listImages());
			
			Flavors flavors = novaClient.execute(FlavorsCore.listFlavors());
			
			ServerForCreate serverForCreate = new ServerForCreate();
			serverForCreate.setName("woorea");
			serverForCreate.setFlavorRef(flavors.getList().get(0).getId());
			serverForCreate.setImageRef(images.getList().get(1).getId());
			serverForCreate.setKeyName(keysPairs.getList().get(0).getName());
			serverForCreate.getSecurityGroups().add(new ServerForCreate.SecurityGroup("default"));
			//serverForCreate.getSecurityGroups().add(new ServerForCreate.SecurityGroup(securityGroup.getName()));
			
			Server server = novaClient.execute(ServersCore.createServer(serverForCreate));
			System.out.println(server);
			
		} else {
			System.out.println("No tenants found!");
		}
		
	}

}
