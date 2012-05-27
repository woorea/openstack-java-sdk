package org.openstack.client.compute;

import org.testng.annotations.Test;

public class NetworksIT extends ComputeIntegrationTest {

	@Test
	public void list() {
		compute.networks().get();
	}
	
	@Test
	public void show() {
		compute.networks().network("465254a5-7393-4e1b-8a88-7d635b40ae00").get();
	}
	
	@Test
	public void delete() {
		compute.networks().network("465254a5-7393-4e1b-8a88-7d635b40ae00").delete();
	}
	
}
