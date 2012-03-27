package org.openstack.ui.client.api;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.UserList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("identity")
public interface IdentityService extends RemoteService {

	Access getSessionData();
	
	Access authenticate(Authentication authentication);
	
	TenantList listTenants();
	
	ServiceList listServices();
	
	EndpointList listEndpontTemplates();

	UserList listUsers();

	RoleList listRoles();
	
}
