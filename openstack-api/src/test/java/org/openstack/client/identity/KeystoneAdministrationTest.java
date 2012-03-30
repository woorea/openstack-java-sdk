package org.openstack.client.identity;

import javax.ws.rs.core.Response;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.model.identity.keystone.KeystoneRole;
import org.openstack.model.identity.keystone.KeystoneService;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.model.identity.keystone.KeystoneUser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class KeystoneAdministrationTest extends AbstractOpenStackTest {
	
	private IdentityAdministrationEndpoint identity;
	
	private Tenant tenant;
	private User user;
	private Role role;
	private Service service;
	private Endpoint endpoint;
	
	@BeforeClass
	public void init() {
		init("/openstack.admin.properties");
		identity = client.getIdentityAdministationEndpoint();
	}
	
	@Test(priority = 1)
	public void createTenant() {
		KeystoneTenant kst = new KeystoneTenant();
		kst.setName("test");
		kst.setDescription("desc");
		kst.setEnabled(true);
		tenant = identity.tenants().post(kst);
		Assert.assertNotNull(tenant);
	}
	
	@Test(priority = 2)
	public void createUser() {
		KeystoneUser ksu = new KeystoneUser();
		ksu.setName("test");
		ksu.setPassword("secret0");
		ksu.setEmail("test@test.com");
		ksu.setEnabled(true);
		user = identity.users().post(ksu);
		Assert.assertNotNull(user);
	}
	
	@Test(priority = 3)
	public void createRole() {
		KeystoneRole ksr = new KeystoneRole();
		role = identity.roles().post(ksr);
		Assert.assertNotNull(role);
	}
	
	@Test(priority = 5)
	public void createService() {
		KeystoneService kss = new KeystoneService();
		kss.setName("test");
		kss.setType("compute");
		kss.setDescription("Nova 3");
		service = identity.services().post(kss);
		Assert.assertNotNull(service);
	}
	
	@Test(priority = 6)
	public void createEndpoint() {
		KeystoneEndpoint kse = new KeystoneEndpoint();
		
		kse.setRegion("RegionOne");
		kse.setServiceId(service.getId());
		kse.setPublicURL("http://192.168.1.52:8774/v2/$(tenant_id)s");
		kse.setInternalURL("http://192.168.1.52:8774/v2/$(tenant_id)s");
		kse.setAdminURL("http://192.168.1.52:8774/v2/$(tenant_id)s");
		
		endpoint = identity.endpoints().post(kse);
		Assert.assertNotNull(endpoint);
	}

	
	public void listTenants() {
		TenantList tenants = identity.tenants().get();
		Assert.assertNotNull(tenants);
	}
	
	@Test(dependsOnMethods={"createTenant"})
	public void listTenantUsers() {
		UserList users = identity.tenants().tenant(tenant.getId()).users().get();
		Assert.assertNotNull(users);
	}
	
	@Test(dependsOnMethods={"createTenant"}, priority = 500)
	public void deleteTenant() {
		Response response = identity.tenants().tenant(tenant.getId()).delete();
		Assert.assertNotNull(response);
	}
	
	public void listUsers() {
		UserList users = identity.users().get();
		Assert.assertNotNull(users);
	}
	
	@Test(dependsOnMethods={"createUser"})
	public void updateUser() {
		KeystoneUser ksu = (KeystoneUser) user;
		ksu.setEmail("luis@woorea.es");
		user = identity.users().user(user.getId()).put(ksu);
		Assert.assertNotNull(user);
	}
	
	@Test(dependsOnMethods={"createUser"})
	public void updateUserPassword() {
		KeystoneUser ksu = (KeystoneUser) user;
		ksu.setPassword("testing");
		identity.users().user(user.getId()).password(user);
		Assert.assertNotNull(user);
	}
	
	@Test(dependsOnMethods={"createUser"})
	public void updateUserTenant() {
//		identity.users().user(user.getId()).password(user);
//		Assert.assertNotNull(user);
	}
	
	@Test(dependsOnMethods={"createUser"})
	public void updateUserEnabled() {
		KeystoneUser ksu = (KeystoneUser) user;
		ksu.setEnabled(false);
		identity.users().user(user.getId()).enabled(user);
		Assert.assertNotNull(user);
	}
	
	@Test(dependsOnMethods={"createUser"}, priority = 400)
	public void deleteUser() {
		Response response = identity.users().user(user.getId()).delete();
		Assert.assertNotNull(response);
	}
	
	
	
	@Test(dependsOnMethods={"createService"})
	public void showService() {
		service = identity.services().service(service.getId()).get();
		Assert.assertNotNull(service);
	}
	
	public void listServices() {
		ServiceList services = identity.services().get();
		Assert.assertNotNull(services);
	}
	
	@Test(dependsOnMethods={"createService"}, priority = 200)
	public void deleteService() {
		Response response = identity.services().service("").delete();
		Assert.assertNotNull(response);
	}
	

	
	public void listEndpoints() {
		EndpointList endpoints = identity.endpoints().get();
		Assert.assertNotNull(endpoints);
	}
	
	@Test(dependsOnMethods={"createEndpoint"}, priority = 100)
	public void deleteEndpoint() {
		Response response = identity.endpoints().endpoint(endpoint.getId()).delete();
		Assert.assertNotNull(response);
	}
	
	
	
	@Test(dependsOnMethods={"createRole"})
	public void showRole() {
		role = identity.roles().role(role.getId()).get();
		Assert.assertNotNull(role);
	}
	
	public void listRoles() {
		RoleList roles = identity.roles().get();
		Assert.assertNotNull(roles);
	}
	
	@Test(dependsOnMethods={"createRole"}, priority = 300)
	public void deleteRole() {
		Response response = identity.roles().role("").delete();
		Assert.assertNotNull(response);
	}
}
