package org.openstack.client;

import java.util.List;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserForCreate;

public class IdentityClient {
	
	IdentityAdministrationEndpoint endpoint;

	public IdentityClient(IdentityAdministrationEndpoint endpoint) {
		this.endpoint = endpoint;
	}

	public TenantList listTenants(int start, int max) {
		return endpoint.tenants().get();
	}

	public Tenant createTenant(Tenant tenant) {
		return endpoint.tenants().post(tenant);
	}

	public void deleteTenant(String id) {
		endpoint.tenants().tenant(id).delete();
	}

	public List<User> listUsers() {
		return endpoint.users().get().getList();
	}

	public User createUser(UserForCreate userForCreate) {
		return endpoint.users().post(userForCreate);
	}

	public void deleteUser(String id) {
		endpoint.users().user(id).delete();
	}

	public List<Role> listRoles() {
		return endpoint.roles().get().getList();
	}

	public Role createRole(Role role) {
		return endpoint.roles().post(role);
	}

	public void deleteRole(String id) {
		endpoint.roles().role(id).delete();
		
	}

	public List<Service> listServices() {
		return endpoint.services().get().getList();
	}

	public Service createService(Service service) {
		return endpoint.services().post(service);
	}

	public void deleteService(String id) {
		endpoint.services().service(id).delete();
	}

	public List<Endpoint> listEndpoints() {
		return endpoint.endpoints().get().getList();
	}

	public Endpoint createEndpoint(Endpoint endpointForCreate) {
		return endpoint.endpoints().post(endpointForCreate);
	}

	public void deleteEndpoint(String id) {
		endpoint.endpoints().endpoint(id).delete();
		
	}

}
