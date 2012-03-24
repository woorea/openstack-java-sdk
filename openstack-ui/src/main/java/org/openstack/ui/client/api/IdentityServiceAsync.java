package org.openstack.ui.client.api;

import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneUserList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IdentityServiceAsync {

	void getSessionData(AsyncCallback<KeystoneAccess> callback);

	void authenticate(KeystoneAuthentication authentication, AsyncCallback<KeystoneAccess> callback);
	
	void listTenants(AsyncCallback<KeystoneTenantList> callback);
	
	void listUsers(AsyncCallback<KeystoneUserList> callback);
	
	void listRoles(AsyncCallback<KeystoneRoleList> callback);
	
	void listServices(AsyncCallback<KeystoneServiceList> callback);

	void listEndpontTemplates(
			AsyncCallback<KeystoneEndpointTemplatesList> callback);

}
