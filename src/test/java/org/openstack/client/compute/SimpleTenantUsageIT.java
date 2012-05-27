package org.openstack.client.compute;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTenantUsageIT extends ComputeIntegrationTest {
	
	@BeforeClass
	public void init() {
		init("etc/openstack.admin.properties");
		compute = client.getComputeEndpoint();
	}

	@Test
	public void list() {
		compute.usages().get(null, null);
	}
	
	@Test
	public void show() {
		compute.usages().tenant("a38ad80666164604b4537224a07aea7e").get(null, null);
	}
	
}
