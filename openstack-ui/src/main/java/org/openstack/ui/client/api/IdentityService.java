package org.openstack.ui.client.api;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenantList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("identity")
public interface IdentityService extends RemoteService {

	OpenStackSessionData getSessionData();
	
	KeyStoneAccess authenticate(KeyStoneAuthentication authentication);
	
	KeyStoneTenantList listTenants();
	
}
