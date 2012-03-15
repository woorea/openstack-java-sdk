package org.openstack.ui.server;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.api.IdentityService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class IdentityServlet extends RemoteServiceServlet implements IdentityService {

	private IdentityService service = new IdentityServiceImpl();

	@Override
	public KeyStoneAccess authenticate(String authURL,
			KeyStoneAuthentication authentication) {
		return service.authenticate(authURL, authentication);
	}

	@Override
	public KeyStoneTenantList listTenants(String identityURL, String token) {
		return service.listTenants(identityURL, token);
	}

	@Override
	public OpenStackSessionData getSession() {
		if(service instanceof IdentityServiceMock) {
			return service.getSession();
		} else {
			return (OpenStackSessionData) perThreadRequest.get().getSession().getAttribute(Constants.OPENSTACK_SESSION);
		}
	}
	
	

}
