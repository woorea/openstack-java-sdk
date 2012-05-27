package org.openstack.client.compute;

import org.openstack.model.compute.nova.cloudpipe.NovaCloudPipeForCreate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudPipeIT extends ComputeIntegrationTest {
	
	@BeforeClass
	public void init() {
		init("etc/openstack.admin.properties");
		compute = client.getComputeEndpoint();
	}

	@Test
	public void create() {
		NovaCloudPipeForCreate request = new NovaCloudPipeForCreate();
		request.setProjectId("a38ad80666164604b4537224a07aea7e");
		compute.cloudPipe().post(request);
	}
	
	@Test
	public void list() {
		compute.cloudPipe().get();
	}
	
}
