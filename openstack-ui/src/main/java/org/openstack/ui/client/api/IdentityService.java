package org.openstack.ui.client.api;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("identity")
public interface IdentityService extends RemoteService {

	OpenStackSessionData getSession();
	
	KeyStoneAccess authenticate(String identityURL, KeyStoneAuthentication authentication);
	
	KeyStoneTenantList listTenants(String identityURL, String token);
	
}
