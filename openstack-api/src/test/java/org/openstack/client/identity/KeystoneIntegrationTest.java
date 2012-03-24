package org.openstack.client.identity;

import static javax.ws.rs.client.Entity.json;

import javax.ws.rs.core.Response;

import org.openstack.api.identity.IdentityResource;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.identity.KeystoneEndpointTemplates;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;
import org.openstack.model.identity.KeystoneRole;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneUser;
import org.openstack.model.identity.KeystoneUserList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class KeystoneIntegrationTest extends AbstractOpenStackTest {
	
	private IdentityResource identity;
	
	private KeystoneTenant tenant;
	private KeystoneUser user;
	private KeystoneRole role;
	private KeystoneService service;
	
	@BeforeClass
	public void init() {
		super.init();
		client.getAccess().getToken().setId("secret0");
		identity = client.target("http://192.168.1.52:35357/v2.0", IdentityResource.class);
	}
	
	@Test(priority = 1)
	public void createTenant() {
		tenant = new KeystoneTenant();
		tenant.setName("test");
		tenant.setDescription("desc");
		tenant.setEnabled(true);
		tenant = identity.tenants().post(json(tenant));
		Assert.assertNotNull(tenant);
	}
	
	@Test(priority = 2)
	public void createUser() {
		user = new KeystoneUser();
		user.setName("test");
		user.setPassword("secret0");
		user.setEmail("test@test.com");
		user.setEnabled(true);
		user = identity.users().post(json(user));
		Assert.assertNotNull(user);
	}
	
	@Test(priority = 3)
	public void createRole() {
		role = new KeystoneRole();
		role = identity.roles().post(json(role));
		Assert.assertNotNull(role);
	}
	
	@Test(dependsOnMethods={"createTenant","createUser","createRole"}, priority = 4)
	public void addRoleToUserOnTenant() {
		role = identity.tenants().tenant(tenant.getId()).users().user(user.getId()).roles().role(role.getId()).put();
		Assert.assertNotNull(role);
	}
	
	@Test(priority = 5)
	public void createService() {
		service = new KeystoneService();
		service.setName("test");
		service.setType("compute");
		service.setDescription("Nova 3");
		service = identity.services().post(json(service));
		Assert.assertNotNull(service);
	}
	
	@Test(priority = 6)
	public void createEndpoint() {
//		KeyStoneEndpointTemplates endpoints = new KeyStoneEndpointTemplates();
//		endpoints = identity.endpoints().post(json(endpoints));
//		Assert.assertNotNull(endpoints);
	}
	

	
	public void listTenants() {
		KeystoneTenantList tenants = identity.tenants().get();
		Assert.assertNotNull(tenants);
	}
	
	@Test(dependsOnMethods={"createTenant"})
	public void listTenantUsers() {
		KeystoneUserList users = identity.tenants().tenant(tenant.getId()).users().get();
		Assert.assertNotNull(users);
	}
	
	@Test(dependsOnMethods={"createTenant"}, priority = 500)
	public void deleteTenant() {
		Response response = identity.tenants().tenant(tenant.getId()).delete();
		Assert.assertNotNull(response);
	}
	
	public void listUsers() {
		KeystoneUserList users = identity.users().get();
		Assert.assertNotNull(users);
	}
	
	@Test(dependsOnMethods={"createUser"})
	public void updateUser() {
		user.setEmail("luis@woorea.es");
		user = identity.users().user(user.getId()).put(json(user));
		Assert.assertNotNull(user);
	}
	
	@Test(dependsOnMethods={"createUser"})
	public void updateUserPassword() {
		user.setPassword("testing");
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
		user.setEnabled(false);
		identity.users().user(user.getId()).enabled(user);
		Assert.assertNotNull(user);
	}
	
	@Test(dependsOnMethods={"createUser"}, priority = 400)
	public void deleteUser() {
		Response response = identity.users().user(user.getId()).delete();
		Assert.assertNotNull(response);
	}
	

	
	@Test(dependsOnMethods={"addRoleToUserOnTenant"}, priority = 50)
	public void deleteRoleFromUserOnTenant() {
		Response response = identity.tenants().tenant(tenant.getId()).users().user(user.getId()).roles().role(role.getId()).delete();
		Assert.assertNotNull(response);
	}
	
	
	
	@Test(dependsOnMethods={"createService"})
	public void showService() {
		service = identity.services().service(service.getId()).get();
		Assert.assertNotNull(service);
	}
	
	public void listServices() {
		KeystoneServiceList services = identity.services().get();
		Assert.assertNotNull(services);
	}
	
	@Test(dependsOnMethods={"createService"}, priority = 200)
	public void deleteService() {
		Response response = identity.services().service("").delete();
		Assert.assertNotNull(response);
	}
	

	
	public void listEndpoints() {
//		KeyStoneEndpointTemplatesList endpoints = identity.endpoints().get();
//		Assert.assertNotNull(endpoints);
	}
	
	@Test(dependsOnMethods={"createEndpoint"}, priority = 100)
	public void deleteEndpoint() {
//		Response response = identity.endpoints().endpointTemplate("").delete();
//		Assert.assertNotNull(response);
	}
	
	
	
	@Test(dependsOnMethods={"createRole"})
	public void showRole() {
		role = identity.roles().role(role.getId()).get();
		Assert.assertNotNull(role);
	}
	
	public void listRoles() {
		KeystoneRoleList roles = identity.roles().get();
		Assert.assertNotNull(roles);
	}
	
	@Test(dependsOnMethods={"createRole"}, priority = 300)
	public void deleteRole() {
		Response response = identity.roles().role("").delete();
		Assert.assertNotNull(response);
	}
}
