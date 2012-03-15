package org.openstack.ui.client.api;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IdentityServiceAsync {
	
	void authenticate(String identityURL, KeyStoneAuthentication authentication, AsyncCallback<KeyStoneAccess> callback);

	void listTenants(String identityURL, String token, AsyncCallback<KeyStoneTenantList> callback);

	void getSession(AsyncCallback<OpenStackSessionData> callback);

	

	

}
