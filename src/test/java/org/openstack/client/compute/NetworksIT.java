package org.openstack.client.compute;

public class NetworksIT extends ComputeIntegrationTest {

	public void list() {
		compute.networks().get();
	}
	
	public void show() {
		compute.networks().network("").get();
	}
	
	public void delete() {
		compute.networks().network("").delete();
	}
	
}
