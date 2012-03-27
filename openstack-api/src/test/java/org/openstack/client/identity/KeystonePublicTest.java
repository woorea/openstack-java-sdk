package org.openstack.client.identity;

import org.openstack.api.identity.IdentityPublicEndpoint;
import org.openstack.client.AbstractOpenStackTest;
import org.openstack.model.identity.KeystoneTenantList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class KeystonePublicTest extends AbstractOpenStackTest {
	
	private IdentityPublicEndpoint identity;
	
	@BeforeClass
	public void init() {
		init("/openstack.properties");
		identity = client.getIdentityEndpoint();
	}
	
	public void listTenants() {
		KeystoneTenantList tenants = identity.tenants().get();
		Assert.assertNotNull(tenants);
	}
	
}