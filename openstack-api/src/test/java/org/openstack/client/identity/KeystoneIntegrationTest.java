package org.openstack.client.identity;

import org.openstack.client.AbstractOpenStackTest;
import org.openstack.client.common.OpenstackAuthenticationClient;
import org.openstack.client.utils.RandomUtil;

public abstract class KeystoneIntegrationTest extends AbstractOpenStackTest {
	protected RandomUtil random = new RandomUtil();

	protected OpenstackAuthenticationClient getAuthenticationClient() {
		return context.session.getAuthenticationClient();
	}
	
}
