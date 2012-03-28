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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("identity")
public interface IdentityService extends RemoteService {

	Access getSessionData();
	
	Access authenticate(Authentication authentication);
	
	TenantList listTenants();
	
	Tenant createTenant(Tenant tenant);
	
	void deleteTenant(String id);
	
	ServiceList listServices();
	
	Service createService(Service service);
	
	void deleteService(String id);
	
	UserList listUsers();
	
	User createUser(User user);
	
	void deleteUser(String id);

	RoleList listRoles();
	
	Role createRole(Role role);
	
	void deleteRole(String id);
	
	EndpointList listEndpoints();
	
	Endpoint createEndpoint(Endpoint endpoint);
	
	void deleteEndpoint(String id);
	
}
