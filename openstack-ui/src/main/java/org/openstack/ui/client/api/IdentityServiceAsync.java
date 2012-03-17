package org.openstack.ui.client.api;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IdentityServiceAsync {
	
	void listTenants(AsyncCallback<KeyStoneTenantList> callback);

	void getSessionData(AsyncCallback<OpenStackSessionData> callback);

	void authenticate(KeyStoneAuthentication authentication, AsyncCallback<KeyStoneAccess> callback);

}
