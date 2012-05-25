package org.openstack.client.compute;

public class FloatingIpPoolsIT extends ComputeIntegrationTest {

	public void list() {
		compute.floatingIpPools().get();
	}
	
}
