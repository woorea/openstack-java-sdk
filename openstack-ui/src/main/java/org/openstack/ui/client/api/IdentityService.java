package org.openstack.ui.client.api;

import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;
import org.openstack.model.identity.KeyStoneRoleList;
import org.openstack.model.identity.KeyStoneServiceList;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.model.identity.KeyStoneUserList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("identity")
public interface IdentityService extends RemoteService {

	KeyStoneAccess getSessionData();
	
	KeyStoneAccess authenticate(KeyStoneAuthentication authentication);
	
	KeyStoneTenantList listTenants();
	
	KeyStoneServiceList listServices();
	
	KeyStoneEndpointTemplatesList listEndpontTemplates();

	KeyStoneUserList listUsers();

	KeyStoneRoleList listRoles();
	
}
