package org.openstack.ui.server.mock;

import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneToken;
import org.openstack.ui.server.LoginService;

public class LoginServiceMock implements LoginService {

	@Override
	public KeyStoneAccess login(String identityURL, String username, String password) {
	
		KeyStoneTenant tenant = new KeyStoneTenant();
		tenant.setId("123");
		
		KeyStoneToken token = new KeyStoneToken();
		token.setId("123");
		token.setTenant(tenant);
		
		KeyStoneAccess access = new KeyStoneAccess();
		access.setToken(token);
		
		return access;
		
	}

}
