package org.openstack.ui.server;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;
import org.openstack.model.identity.KeyStoneRoleList;
import org.openstack.model.identity.KeyStoneServiceList;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.model.identity.KeyStoneUserList;
import org.openstack.ui.client.api.IdentityService;

@SuppressWarnings("serial")
public class IdentityServlet extends OpenStackRemoteServiceServlet implements IdentityService {

	@Override
	public KeyStoneAccess authenticate(KeyStoneAuthentication authentication) {
		return getClient().identity().administrationEndpoint().tokens().authenticate(authentication);
	}

	@Override
	public KeyStoneTenantList listTenants() {
		return getClient().identity().administrationEndpoint().tenants().get();
	}

	@Override
	public OpenStackSessionData getSessionData() {
		return null; // getSession().getData();
	}

	@Override
	public KeyStoneServiceList listServices() {
		return getClient().identity().administrationEndpoint().services().get();
	}

	@Override
	public KeyStoneEndpointTemplatesList listEndpontTemplates() {
		return getClient().identity().administrationEndpoint().endpoints().get();
	}

	@Override
	public KeyStoneUserList listUsers() {
		return getClient().identity().administrationEndpoint().users().get();
	}

	@Override
	public KeyStoneRoleList listRoles() {
		return getClient().identity().administrationEndpoint().roles().get();
	}
	
	
	
	

}
