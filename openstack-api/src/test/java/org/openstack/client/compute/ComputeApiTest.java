package org.openstack.client.compute;

import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackClient;
import org.openstack.client.common.OpenstackComputeClient;
import org.testng.annotations.Test;

@Test
public class ComputeApiTest extends AbstractOpenStackTest {
	public OpenstackComputeClient getComputeClient() throws OpenstackException {
		OpenstackClient client = context.client;
		return client.getComputeClient();
	}
}
