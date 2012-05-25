package org.openstack.client.compute;

import org.openstack.model.compute.nova.cloudpipe.NovaCloudPipeForCreate;

public class CloudPipeIT extends ComputeIntegrationTest {

	public void create() {
		NovaCloudPipeForCreate request = new NovaCloudPipeForCreate();
		request.setTenantId("1");
		compute.cloudPipe().post(request);
	}
	
	public void list() {
		compute.cloudPipe().get();
	}
	
}
