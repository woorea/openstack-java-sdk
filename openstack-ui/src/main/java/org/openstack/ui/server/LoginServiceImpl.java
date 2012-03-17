package org.openstack.ui.server;

import org.openstack.client.common.OpenStackSession;
import org.openstack.client.common.OpenStackSession.Feature;
import org.openstack.client.identity.IdentityResource;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;

public class LoginServiceImpl implements LoginService {

	@Override
	public OpenStackSession login(String identityURL, String username, String password) {
		KeyStoneAuthentication authentication = new KeyStoneAuthentication().withPasswordCredentials(username, password);
		
		OpenStackSession oss = OpenStackSession.create().with(Feature.VERBOSE);
		
		IdentityResource identity = new IdentityResource(oss, identityURL);
		
		KeyStoneAccess access = identity.tokens().authenticate(authentication);
		
		oss.getData().setAccess(access);
		
		KeyStoneTenantList tenants = identity.tenants().list();
		
		KeyStoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		access = identity.tokens().authenticate(authentication);
		
		oss.getData().setAccess(access);
		
		return oss;
	}

}
