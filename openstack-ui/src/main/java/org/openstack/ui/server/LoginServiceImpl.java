package org.openstack.ui.server;

import org.openstack.api.identity.IdentityResource;
import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;

public class LoginServiceImpl implements LoginService {

	@Override
	public KeyStoneAccess login(String identityURL, String username, String password) {
		KeyStoneAuthentication authentication = new KeyStoneAuthentication().withPasswordCredentials(username, password);
		
		OpenStackClient oss = OpenStackClientFactory.authenticate(identityURL, username, password);
		
		IdentityResource identity = oss.identity().publicEndpoint();
		
		KeyStoneAccess access = identity.tokens().authenticate(authentication);
		
		//oss.getData().setAccess(access);
		
		KeyStoneTenantList tenants = identity.tenants().get();
		
		KeyStoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		access = identity.tokens().authenticate(authentication);
		
		//oss.getData().setAccess(access);
		
		return access;
	}

}
