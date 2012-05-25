package org.openstack.client.compute;

import org.openstack.api.compute.ext.HostResource.HostAction;
import org.openstack.model.compute.nova.host.UpdateNovaHostRequest;

public class HostsIT extends ComputeIntegrationTest {

	public void update() {
		UpdateNovaHostRequest request = new UpdateNovaHostRequest();
		compute.hosts().host("1").put(request);
	}
	
	public void list() {
		compute.hosts().get();
	}
	
	public void startup() {
		compute.hosts().host("1").get(HostAction.STARTUP);
	}
	
	public void shutdown() {
		compute.hosts().host("1").get(HostAction.SHUTDOWN);
	}
	
	public void reboot() {
		compute.hosts().host("1").get(HostAction.REBOOT);
	}
	
}
