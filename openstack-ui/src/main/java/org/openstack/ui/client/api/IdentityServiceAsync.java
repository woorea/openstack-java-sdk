package org.openstack.ui.client.api;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneEndpointTemplates;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;
import org.openstack.model.identity.KeyStoneRoleList;
import org.openstack.model.identity.KeyStoneServiceList;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.model.identity.KeyStoneUserList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IdentityServiceAsync {

	void getSessionData(AsyncCallback<OpenStackSessionData> callback);

	void authenticate(KeyStoneAuthentication authentication, AsyncCallback<KeyStoneAccess> callback);
	
	void listTenants(AsyncCallback<KeyStoneTenantList> callback);
	
	void listUsers(AsyncCallback<KeyStoneUserList> callback);
	
	void listRoles(AsyncCallback<KeyStoneRoleList> callback);
	
	void listServices(AsyncCallback<KeyStoneServiceList> callback);

	void listEndpontTemplates(
			AsyncCallback<KeyStoneEndpointTemplatesList> callback);

}
