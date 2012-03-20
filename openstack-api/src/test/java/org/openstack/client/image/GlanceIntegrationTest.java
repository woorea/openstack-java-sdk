package org.openstack.client.image;

import org.openstack.client.AbstractOpenStackTest;
import org.testng.SkipException;

public abstract class GlanceIntegrationTest extends AbstractOpenStackTest {

	protected void skipIfNoGlance() {
		if (!glanceEnabled) {
			throw new SkipException("Skipping because glance not present / accessible");
		}
	}
}
