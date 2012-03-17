package org.openstack.ui.server;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;

public class IdentityServiceImpl {

	public KeyStoneAccess authenticate(String identityURL, KeyStoneAuthentication authentication) {
		
		//IdentityResource identity = new IdentityResource(oss, identityURL);
		
		//return identity.tokens().authenticate(authentication);
		
		return null;
		
	}

	public KeyStoneTenantList listTenants(OpenStackSession session) {
		return session.getAuthenticationClient().root().tenants().list();
		
	}

}
