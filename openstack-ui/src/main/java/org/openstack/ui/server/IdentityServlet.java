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

	@Override
	public KeyStoneServiceList listServices() {
		return getSession().getAuthenticationClient().admin().services().list();
	}

	@Override
	public KeyStoneEndpointTemplatesList listEndpontTemplates() {
		return getSession().getAuthenticationClient().admin().endpointTemplates().list();
	}

	@Override
	public KeyStoneUserList listUsers() {
		return getSession().getAuthenticationClient().admin().users().list();
	}

	@Override
	public KeyStoneRoleList listRoles() {
		return getSession().getAuthenticationClient().admin().roles().list();
	}
	
	
	
	

}
