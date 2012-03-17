package org.openstack.ui.server;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.api.IdentityService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class IdentityServlet extends RemoteServiceServlet implements IdentityService {

	private IdentityServiceImpl service = new IdentityServiceImpl();

	@Override
	public KeyStoneAccess authenticate(KeyStoneAuthentication authentication) {
		OpenStackSession session = getSession();
		return session.getAuthenticationClient().root().tokens().authenticate(authentication);
	}

	@Override
	public KeyStoneTenantList listTenants() {
		return service.listTenants(getSession());
	}

	@Override
	public OpenStackSessionData getSessionData() {
		return getSession().getData();
	}
	
	private OpenStackSession getSession() {
		return (OpenStackSession) perThreadRequest.get().getSession().getAttribute(Constants.OPENSTACK_SESSION);
	}
	
	

}
