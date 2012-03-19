package org.openstack.client.identity;

import org.openstack.api.common.OpenstackAuthenticationClient;
import org.openstack.client.AbstractOpenStackTest;

public abstract class KeystoneIntegrationTest extends AbstractOpenStackTest {

	protected OpenstackAuthenticationClient getAuthenticationClient() {
		return context.session.getAuthenticationClient();
	}
	
}
