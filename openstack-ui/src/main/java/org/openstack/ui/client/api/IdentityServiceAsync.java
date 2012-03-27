package org.openstack.ui.client.api;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.UserList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IdentityServiceAsync {

	void authenticate(Authentication authentication,
			AsyncCallback<Access> callback);

	void getSessionData(AsyncCallback<Access> callback);

	void listEndpontTemplates(AsyncCallback<EndpointList> callback);

	void listRoles(AsyncCallback<RoleList> callback);

	void listServices(AsyncCallback<ServiceList> callback);

	void listTenants(AsyncCallback<TenantList> callback);

	void listUsers(AsyncCallback<UserList> callback);

}
