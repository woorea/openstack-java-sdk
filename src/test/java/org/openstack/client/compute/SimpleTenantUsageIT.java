package org.openstack.client.compute;

public class SimpleTenantUsageIT extends ComputeIntegrationTest {

	public void list() {
		compute.usages().get("", "");
	}
	
	public void show() {
		compute.usages().tenant("").get("", "");
	}
	
}
