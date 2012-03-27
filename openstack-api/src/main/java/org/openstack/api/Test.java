package org.openstack.api;

import java.io.File;
import java.util.List;

import org.openstack.api.compute.TenantResource;
import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.compute.ServerList;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeystoneRole;
import org.openstack.model.identity.keystone.KeystoneService;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.model.identity.keystone.KeystoneUser;
import org.openstack.model.storage.swift.SwiftContainer;
import org.openstack.model.storage.swift.SwiftStorageObjectProperties;

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
		
		TenantList tenants = identity.tenants().get();

		KeystoneTenant kst = new KeystoneTenant();
		kst.setName("test");
		kst.setDescription("desc");
		kst.setEnabled(true);
		Tenant tenant = identity.tenants().post(kst);

		tenant = identity.tenants().tenant(tenant.getId()).get();

		identity.tenants().tenant(tenant.getId()).delete();

		UserList users = identity.users().get();

		KeystoneUser ksu = new KeystoneUser();
		ksu.setName("test");
		ksu.setPassword("secret0");
		ksu.setEmail("test@test.com");
		ksu.setEnabled(true);
		User user = identity.users().post(ksu);

		user = identity.users().user(user.getId()).get();

		identity.users().user(user.getId()).delete();

		RoleList roles = identity.roles().get();

		KeystoneRole ksr = new KeystoneRole();
		ksr.setName("test");
		Role role = identity.roles().post(ksr);

		role = identity.roles().role(role.getId()).get();

		identity.roles().role(role.getId()).delete();

		ServiceList services = identity.services().get();

		KeystoneService kss = new KeystoneService();
		kss.setName("test");
		kss.setType("compute");
		kss.setDescription("Nova 3");
		Service service = identity.services().post(kss);

		service = identity.services().service(service.getId()).get();

		identity.services().service(service.getId()).delete();

		//Endpoints 501
		
		openstack = openstack.reauthenticateOnTenant("admin");
				
		
		TenantResource compute = openstack.getComputeEndpoint();

		ServerList servers = compute.servers().get();
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
		
		SwiftStorageObjectProperties p = new SwiftStorageObjectProperties();
		openstack.getStorageEndpoint().container(sAccount.get(0).getName()).object("test2").put(new File("logging.properties"), p);

	}

}
