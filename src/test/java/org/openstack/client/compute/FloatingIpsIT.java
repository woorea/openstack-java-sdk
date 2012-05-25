package org.openstack.client.compute;

import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;
import org.testng.annotations.Test;

public class FloatingIpsIT extends ComputeIntegrationTest {
	
	private FloatingIp floatingIp;

	@Test
	public void listFloatingIps() {
		FloatingIpList ips = compute.floatingIps().get();
	}
	
	@Test
	public void createFloatingIp() throws Exception {
		
		floatingIp = compute.floatingIps().post(null);

	}
	
	@Test(dependsOnMethods="createFloatingIp", priority=1000)
	public void deleteFloatingIp() {
		compute.floatingIps().floatingIp(floatingIp.getId()).delete();
	}
	
}
