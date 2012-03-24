package org.openstack.ui.client.api;

import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneUserList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("identity")
public interface IdentityService extends RemoteService {

	KeystoneAccess getSessionData();
	
	KeystoneAccess authenticate(KeystoneAuthentication authentication);
	
	KeystoneTenantList listTenants();
	
	KeystoneServiceList listServices();
	
	KeystoneEndpointTemplatesList listEndpontTemplates();

	KeystoneUserList listUsers();

	KeystoneRoleList listRoles();
	
}
