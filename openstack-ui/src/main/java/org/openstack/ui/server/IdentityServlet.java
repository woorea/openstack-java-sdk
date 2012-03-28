package org.openstack.ui.server;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;
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
	public EndpointList listEndpoints() {
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

	@Override
	public Service createService(Service service) {
		return getClient().getIdentityAdministationEndpoint().services().post(service);
	}

	@Override
	public Tenant createTenant(Tenant tenant) {
		return getClient().getIdentityAdministationEndpoint().tenants().post(tenant);
	}

	@Override
	public void deleteTenant(String id) {
		getClient().getIdentityAdministationEndpoint().tenants().tenant(id).delete();
		
	}

	@Override
	public void deleteService(String id) {
		getClient().getIdentityAdministationEndpoint().services().service(id).delete();
		
	}

	@Override
	public User createUser(User user) {
		return getClient().getIdentityAdministationEndpoint().users().post(user);
	}

	@Override
	public void deleteUser(String id) {
		getClient().getIdentityAdministationEndpoint().users().user(id).delete();
		
	}

	@Override
	public Role createRole(Role role) {
		return getClient().getIdentityAdministationEndpoint().roles().post(role);
	}

	@Override
	public void deleteRole(String id) {
		getClient().getIdentityAdministationEndpoint().roles().role(id).delete();
		
	}

	@Override
	public Endpoint createEndpoint(Endpoint endpoint) {
		return getClient().getIdentityAdministationEndpoint().endpoints().post(endpoint);
	}

	@Override
	public void deleteEndpoint(String id) {
		getClient().getIdentityAdministationEndpoint().endpoints().endpoint(id).delete();
		
	}
	
	
	
	

}
