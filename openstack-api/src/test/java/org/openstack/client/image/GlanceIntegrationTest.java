package org.openstack.client.image;

import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.common.OpenstackImageClient;
import org.testng.SkipException;

public abstract class GlanceIntegrationTest extends AbstractOpenStackTest {
	protected OpenstackImageClient getImageClient() {
		return context.session.getImageClient();
	}

	protected void skipIfNoGlance() {
		if (!context.isGlanceEnabled()) {
			throw new SkipException("Skipping because glance not present / accessible");
		}
	}
}
