package org.openstack.ui.server.mock;

import java.util.Arrays;
import java.util.List;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;
import org.openstack.model.identity.KeyStoneRoleList;
import org.openstack.model.identity.KeyStoneServiceList;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.model.identity.KeyStoneToken;
import org.openstack.model.identity.KeyStoneUserList;
import org.openstack.ui.client.api.IdentityService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class IdentityServlet extends RemoteServiceServlet implements IdentityService {
	
	private OpenStackSessionData session;

	@Override
	public KeyStoneAccess authenticate(KeyStoneAuthentication authentication) {
		KeyStoneTenant tenant = new KeyStoneTenant(authentication.getTenantId() != null ? authentication.getTenantId() : "1","Tenant.1");
		KeyStoneToken token = new KeyStoneToken();
		token.setId("123");
		token.setExpires("unlimited");
		token.setTenant(tenant);
		KeyStoneAccess access = new KeyStoneAccess();
		access.setToken(token);
		return access;
	}

	@Override
	public KeyStoneTenantList listTenants() {
		List<KeyStoneTenant> tenants =  Arrays.asList(new KeyStoneTenant("1","Tenant.1"), new KeyStoneTenant("2", "Tenant 2"));
		KeyStoneTenantList list = new KeyStoneTenantList();
		list.setList(tenants);
		return list;
	}

	@Override
	public OpenStackSessionData getSessionData() {
		if(session == null) {
			session = new OpenStackSessionData(authenticate(new KeyStoneAuthentication()));
		}
		return session;
	}

	@Override
	public KeyStoneServiceList listServices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyStoneEndpointTemplatesList listEndpontTemplates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyStoneUserList listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyStoneRoleList listRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
