package org.openstack.ui.server;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeystoneAuthentication;
import org.openstack.ui.client.api.IdentityService;

@SuppressWarnings("serial")
public class IdentityServlet extends OpenStackRemoteServiceServlet implements IdentityService {

	@Override
	public Access authenticate(Authentication authentication) {
		return getClient().getIdentityAdministationEndpoint().tokens().post(authentication);
	}

	@Override
	public TenantList listTenants() {
		return getClient().getIdentityAdministationEndpoint().tenants().get();
	}

	@Override
	public Access getSessionData() {
		return getClient().getAccess();
	}

	@Override
	public ServiceList listServices() {
		return getClient().getIdentityAdministationEndpoint().services().get();
	}

	@Override
	public EndpointList listEndpontTemplates() {
		return getClient().getIdentityAdministationEndpoint().endpoints().get();
	}

	@Override
	public UserList listUsers() {
		return getClient().getIdentityAdministationEndpoint().users().get();
	}

	@Override
	public RoleList listRoles() {
		return getClient().getIdentityAdministationEndpoint().roles().get();
	}
	
	
	
	

}
