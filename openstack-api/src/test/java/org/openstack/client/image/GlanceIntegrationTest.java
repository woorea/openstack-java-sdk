package org.openstack.client.image;

import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.utils.RandomUtil;

public abstract class GlanceIntegrationTest extends AbstractOpenStackTest {
	protected RandomUtil random = new RandomUtil();

	protected OpenstackImageClient getImageClient() {
		return context.session.getImageClient();
	}
	
	protected void skipIfNoGlance() {
		// throw new SkipException("Skipping because glance not present");
	}
}
