package org.openstack.ui.client.api;

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

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IdentityServiceAsync {

	void authenticate(Authentication authentication,
			AsyncCallback<Access> callback);

	void createEndpoint(Endpoint endpoint, AsyncCallback<Endpoint> callback);

	void createRole(Role role, AsyncCallback<Role> callback);

	void createService(Service service, AsyncCallback<Service> callback);

	void createTenant(Tenant tenant, AsyncCallback<Tenant> callback);

	void createUser(User user, AsyncCallback<User> callback);

	void deleteEndpoint(String id, AsyncCallback<Void> callback);

	void deleteRole(String id, AsyncCallback<Void> callback);

	void deleteService(String id, AsyncCallback<Void> callback);

	void deleteTenant(String id, AsyncCallback<Void> callback);

	void deleteUser(String id, AsyncCallback<Void> callback);

	void getSessionData(AsyncCallback<Access> callback);

	void listEndpoints(AsyncCallback<EndpointList> callback);

	void listRoles(AsyncCallback<RoleList> callback);

	void listServices(AsyncCallback<ServiceList> callback);

	void listTenants(AsyncCallback<TenantList> callback);

	void listUsers(AsyncCallback<UserList> callback);

}
