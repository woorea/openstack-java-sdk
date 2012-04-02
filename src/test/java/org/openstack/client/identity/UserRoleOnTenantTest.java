package org.openstack.client.identity;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.User;
import org.openstack.model.identity.keystone.KeystoneRole;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.model.identity.keystone.KeystoneUser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserRoleOnTenantTest extends AbstractOpenStackTest {
	
	private IdentityAdministrationEndpoint identity;
	
	private Tenant tenant;
	private User user;
	private Role role;
	
	@BeforeClass
	public void init() {
		init("etc/openstack.admin.properties");
		identity = client.getIdentityAdministationEndpoint();
	}

	@Test
	public void addRoleToUserOnTenant() {
		KeystoneTenant kst = new KeystoneTenant();
		kst.setName("test5");
		kst.setDescription("desc");
		kst.setEnabled(true);
		tenant = identity.tenants().post(kst);
		
		KeystoneUser ksu = new KeystoneUser();
		ksu.setName("test5");
		ksu.setPassword("secret0");
		ksu.setEmail("test@test.com");
		ksu.setEnabled(true);
		user = identity.users().post(ksu);
		
		KeystoneRole ksr = new KeystoneRole();
		ksr.setName("test5");
		role = identity.roles().post(ksr);
		
		role = identity.tenants().tenant(tenant.getId()).users().user(user.getId()).roles().role(role.getId()).put();
		Assert.assertNotNull(role);
	}
	
	@Test(dependsOnMethods={"addRoleToUserOnTenant"})
	public void deleteRoleFromUserOnTenant() {
		identity.tenants().tenant(tenant.getId()).users().user(user.getId()).roles().role(role.getId()).delete();
		identity.roles().role(role.getId()).delete();
		identity.users().user(user.getId()).delete();
		identity.tenants().tenant(tenant.getId()).delete();
	}
	
}
