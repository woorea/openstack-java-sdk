package org.openstack.ui.server;

import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneUserList;
import org.openstack.ui.client.api.IdentityService;

@SuppressWarnings("serial")
public class IdentityServlet extends OpenStackRemoteServiceServlet implements IdentityService {

	@Override
	public KeystoneAccess authenticate(KeystoneAuthentication authentication) {
		return getClient().identity().getPublicEndpoint().tokens().post(authentication);
	}

	@Override
	public KeystoneTenantList listTenants() {
		return getClient().identity().getPublicEndpoint().tenants().get();
	}

	@Override
	public KeystoneAccess getSessionData() {
		return getClient().getAccess();
	}

	@Override
	public KeystoneServiceList listServices() {
		return getClient().identity().getRegionAdministationEndpoint().services().get();
	}

	@Override
	public KeystoneEndpointTemplatesList listEndpontTemplates() {
		return getClient().identity().getRegionAdministationEndpoint().endpoints().get();
	}

	@Override
	public KeystoneUserList listUsers() {
		return getClient().identity().getRegionAdministationEndpoint().users().get();
	}

	@Override
	public KeystoneRoleList listRoles() {
		return getClient().identity().getRegionAdministationEndpoint().roles().get();
	}
	
	
	
	

}
