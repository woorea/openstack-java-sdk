package org.openstack.client.image;

import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.OpenstackImageClient;
import org.testng.SkipException;

public abstract class GlanceIntegrationTest extends AbstractOpenStackTest {
	
	protected OpenstackImageClient client;

	protected void skipIfNoGlance() {
		if (!glanceEnabled) {
			throw new SkipException("Skipping because glance not present / accessible");
		}
	}
}
