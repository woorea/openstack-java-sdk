package org.openstack.client.compute;

import org.openstack.api.compute.ext.HostResource.HostAction;
import org.openstack.model.compute.nova.host.UpdateNovaHostRequest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HostsIT extends ComputeIntegrationTest {
	
	@BeforeClass
	public void init() {
		init("etc/openstack.admin.properties");
		compute = client.getComputeEndpoint();
	}
	
	@Test
	public void list() {
		compute.hosts().get();
	}
	
	@Test
	public void show() {
		System.out.println(compute.hosts().host("openstack").get());
	}

	@Test
	public void enableHost() {
		UpdateNovaHostRequest request = new UpdateNovaHostRequest();
		request.setStatus("enable");
		compute.hosts().host("openstack").put(request);
	}
	
	@Test
	public void disableHost() {
		UpdateNovaHostRequest request = new UpdateNovaHostRequest();
		request.setStatus("disable");
		compute.hosts().host("openstack").put(request);
	}
	
	@Test
	public void enableMaintenance() {
		UpdateNovaHostRequest request = new UpdateNovaHostRequest();
		request.setMaintenanceMode("enable");
		compute.hosts().host("openstack").put(request);
	}
	
	@Test
	public void disableMaintenance() {
		UpdateNovaHostRequest request = new UpdateNovaHostRequest();
		request.setMaintenanceMode("disable");
		compute.hosts().host("openstack").put(request);
	}
	
	@Test
	public void startup() {
		compute.hosts().host("openstack").get(HostAction.STARTUP);
	}
	
	@Test
	public void shutdown() {
		compute.hosts().host("openstack").get(HostAction.SHUTDOWN);
	}
	
	@Test
	public void reboot() {
		compute.hosts().host("openstack").get(HostAction.REBOOT);
	}
	
}
