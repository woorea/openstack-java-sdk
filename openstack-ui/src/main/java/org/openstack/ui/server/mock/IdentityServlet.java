package org.openstack.ui.server.mock;

import java.util.Arrays;
import java.util.List;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;
import org.openstack.model.identity.KeystoneRoleList;
import org.openstack.model.identity.KeystoneServiceList;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.model.identity.KeystoneToken;
import org.openstack.model.identity.KeystoneUserList;
import org.openstack.ui.client.api.IdentityService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class IdentityServlet extends RemoteServiceServlet implements IdentityService {
	
	private KeystoneAccess session;

	@Override
	public KeystoneAccess authenticate(KeystoneAuthentication authentication) {
		KeystoneTenant tenant = new KeystoneTenant(authentication.getTenantId() != null ? authentication.getTenantId() : "1","Tenant.1");
		KeystoneToken token = new KeystoneToken();
		token.setId("123");
		token.setExpires("unlimited");
		token.setTenant(tenant);
		KeystoneAccess access = new KeystoneAccess();
		access.setToken(token);
		return access;
	}

	@Override
	public KeystoneTenantList listTenants() {
		List<KeystoneTenant> tenants =  Arrays.asList(new KeystoneTenant("1","Tenant.1"), new KeystoneTenant("2", "Tenant 2"));
		KeystoneTenantList list = new KeystoneTenantList();
		list.setList(tenants);
		return list;
	}

	@Override
	public KeystoneAccess getSessionData() {
		if(session == null) {
			session = authenticate(new KeystoneAuthentication());
		}
		return session;
	}

	@Override
	public KeystoneServiceList listServices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeystoneEndpointTemplatesList listEndpontTemplates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeystoneUserList listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeystoneRoleList listRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
