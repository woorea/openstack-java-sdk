package org.openstack.ui.server;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.api.IdentityService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class IdentityServlet extends OpenStackRemoteServiceServlet implements IdentityService {

	@Override
	public KeyStoneAccess authenticate(KeyStoneAuthentication authentication) {
		return getSession().getAuthenticationClient().root().tokens().authenticate(authentication);
	}

	@Override
	public KeyStoneTenantList listTenants() {
		return getSession().getAuthenticationClient().root().tenants().list();
	}

	@Override
	public OpenStackSessionData getSessionData() {
		return getSession().getData();
	}
	
	
	
	

}
