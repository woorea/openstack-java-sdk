package org.openstack.ui.server.mock;

import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneToken;
import org.openstack.ui.server.LoginService;

public class LoginServiceMock implements LoginService {

	@Override
	public KeystoneAccess login(String identityURL, String username, String password) {
	
		KeystoneTenant tenant = new KeystoneTenant();
		tenant.setId("123");
		
		KeystoneToken token = new KeystoneToken();
		token.setId("123");
		token.setTenant(tenant);
		
		KeystoneAccess access = new KeystoneAccess();
		access.setToken(token);
		
		return access;
		
	}

}
