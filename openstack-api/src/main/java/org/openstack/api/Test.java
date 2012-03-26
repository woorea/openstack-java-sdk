package org.openstack.api;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Entity;

import org.openstack.api.compute.TenantResource;
import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.compute.NovaFlavorList;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaKeyPairList;
import org.openstack.model.compute.NovaSecurityGroupList;
import org.openstack.model.compute.NovaServerList;
import org.openstack.model.compute.NovaVolumeList;
import org.openstack.model.identity.KeystoneRole;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneUser;
import org.openstack.model.identity.KeystoneUserList;
import org.openstack.model.storage.SwiftContainer;
import org.openstack.model.storage.SwiftObjectProperties;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//Properties properties = new Properties(); 
		
		//properties.setProperty("auth.endpoint", "http://192.168.1.52:5000/v2.0");
		//properties.setProperty("auth.username", "admin");
		//properties.setProperty("auth.password", "secret0");
		
		//properties.setProperty("identity.default.endpoint.adminURL","http://192.168.1.52:35357/v2.0");
		//The admintoken (setted on keystone config file)
		//properties.setProperty("identity.admin.token", "secret0");
		
		OpenStackClient openstack = OpenStackClientFactory.authenticate();

		IdentityAdministrationEndpoint identity = openstack.getIdentityAdministationEndpoint();
		
		KeystoneTenantList tenants = identity.tenants().get();

		KeystoneTenant tenant = new KeystoneTenant();
		tenant.setName("test");
		tenant.setDescription("desc");
		tenant.setEnabled(true);
		tenant = identity.tenants().post(Entity.json(tenant));

		tenant = identity.tenants().tenant(tenant.getId()).get();

		identity.tenants().tenant(tenant.getId()).delete();

		KeystoneUserList users = identity.users().get();

		KeystoneUser user = new KeystoneUser();
		user.setName("test");
		user.setPassword("secret0");
		user.setEmail("test@test.com");
		user.setEnabled(true);
		user = identity.users().post(Entity.json(user));

		user = identity.users().user(user.getId()).get();

		identity.users().user(user.getId()).delete();

		KeystoneRoleList roles = identity.roles().get();

		KeystoneRole role = new KeystoneRole();
		role.setName("test");
		role = identity.roles().post(Entity.json(role));

		role = identity.roles().role(role.getId()).get();

		identity.roles().role(role.getId()).delete();

		KeystoneServiceList services = identity.services().get();

		KeystoneService service = new KeystoneService();
		service.setName("test");
		service.setType("compute");
		service.setDescription("Nova 3");
		service = identity.services().post(Entity.json(service));

		service = identity.services().service(service.getId()).get();

		identity.services().service(service.getId()).delete();

		//Endpoints 501
		
		openstack = openstack.reauthenticateOnTenant("admin");
				
		
		TenantResource compute = openstack.getComputeEndpoint();

		NovaServerList servers = compute.servers().get();
//		
//		NovaImageList images = compute.images().get();
		// "cirros-0.3.0-x86_64-blank"
//		
//		NovaFlavorList flavors = compute.flavors().get();
//		
//		NovaKeyPairList keypairs = compute.keyPairs().get();
//		
//		NovaSecurityGroupList securityGroups = compute.securityGroups().get();
//		
//		NovaVolumeList volumes = compute.volumes().get();
		
//		ImageList gImages = openstack.images().publicEndpoint().get();
		
		List<SwiftContainer> sAccount = openstack.getStorageEndpoint().get();
		
		SwiftObjectProperties p = new SwiftObjectProperties();
		openstack.getStorageEndpoint().container(sAccount.get(0).getName()).object("test2").put(new File("logging.properties"), p);

	}

}
