package org.openstack.client;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.model.identity.keystone.KeystoneService;

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
		
//		TenantList tenants = identity.tenants().get();
//
//		KeystoneTenant kst = new KeystoneTenant();
//		kst.setName("test");
//		kst.setDescription("desc");
//		kst.setEnabled(true);
//		Tenant tenant = identity.tenants().post(kst);
//
//		tenant = identity.tenants().tenant(tenant.getId()).get();
//
//		identity.tenants().tenant(tenant.getId()).delete();
//
//		UserList users = identity.users().get();
//
//		KeystoneUser ksu = new KeystoneUser();
//		ksu.setName("test");
//		ksu.setPassword("secret0");
//		ksu.setEmail("test@test.com");
//		ksu.setEnabled(true);
//		User user = identity.users().post(ksu);
//
//		user = identity.users().user(user.getId()).get();
//
//		identity.users().user(user.getId()).delete();
//
//		RoleList roles = identity.roles().get();
//
//		KeystoneRole ksr = new KeystoneRole();
//		ksr.setName("test");
//		Role role = identity.roles().post(ksr);
//
//		role = identity.roles().role(role.getId()).get();
//
//		identity.roles().role(role.getId()).delete();
//
		ServiceList services = identity.services().get();

//		KeystoneService kss = new KeystoneService();
//		kss.setName("test");
//		kss.setType("compute");
//		kss.setDescription("Nova 3");
//		Service service = identity.services().post(kss);
//
		Service service = identity.services().service(services.getList().get(0).getId()).get();
		
		

		

		identity.endpoints().get();
		
//		KeystoneEndpoint kse = new KeystoneEndpoint();
//		
//		
//		kse.setRegion("RegionOne");
//		kse.setServiceId(service.getId());
//		kse.setPublicURL("http://192.168.1.52:8774/v2/$(tenant_id)s");
//		kse.setInternalURL("http://192.168.1.52:8774/v2/$(tenant_id)s");
//		kse.setAdminURL("http://192.168.1.52:8774/v2/$(tenant_id)s");
//		
//		Endpoint endpoint = identity.endpoints().post(kse);
		
//		identity.endpoints().endpoint(endpoint.getId()).delete();
		
//		identity.services().service(service.getId()).delete();
//		
//		openstack = openstack.reauthenticateOnTenant("admin");
//				
//		
//		TenantResource compute = openstack.getComputeEndpoint();
//
//		ServerList servers = compute.servers().get();
//		
//		ImageList images = compute.images().get();
//		// "cirros-0.3.0-x86_64-blank"
//		
//		FlavorList flavors = compute.flavors().get();
//		
//		KeyPairList keypairs = compute.keyPairs().get();
//		
//		SecurityGroupList securityGroups = compute.securityGroups().get();
//		
//		VolumeList volumes = compute.volumes().get();
//		
//		org.openstack.model.images.ImageList gImages = openstack.getImagesEndpoint().get();
//		
//		List<StorageContainer> sAccount = openstack.getStorageEndpoint().get();
//		
//		SwiftStorageObjectProperties p = new SwiftStorageObjectProperties();
//		openstack.getStorageEndpoint().container(sAccount.get(0).getName()).object("test2").put(new File("logging.properties"), p);

	}

}
