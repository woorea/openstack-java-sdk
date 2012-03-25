package org.openstack.ui.server;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;

public class LoginServiceImpl implements LoginService {

	@Override
	public KeystoneAccess login(String identityURL, String username, String password) {
		KeystoneAuthentication authentication = new KeystoneAuthentication().withPasswordCredentials(username, password);
		
		OpenStackClient openstack = OpenStackClientFactory.authenticate(identityURL, username, password);
		//no services when login without tenant
		IdentityAdministrationEndpoint identity = openstack.target(identityURL, IdentityAdministrationEndpoint.class);
		
		KeystoneAccess access = identity.tokens().post(authentication);
		
		KeystoneTenantList tenants = identity.tenants().get();
		
		KeystoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		access = identity.tokens().post(authentication);
		
		return access;
	}

}
