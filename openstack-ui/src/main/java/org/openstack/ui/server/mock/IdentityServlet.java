package org.openstack.ui.server.mock;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeystoneAccess;
import org.openstack.model.identity.keystone.KeystoneAuthentication;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.model.identity.keystone.KeystoneTenantList;
import org.openstack.model.identity.keystone.KeystoneToken;
import org.openstack.ui.client.api.IdentityService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class IdentityServlet extends RemoteServiceServlet implements IdentityService {
	
	private Access session;

	@Override
	public Access authenticate(Authentication authentication) {
		Tenant tenant = new KeystoneTenant(authentication.getTenantId() != null ? authentication.getTenantId() : "1","Tenant.1");
		KeystoneToken token = new KeystoneToken();
		token.setId("123");
		token.setExpires("unlimited");
		token.setTenant(tenant);
		KeystoneAccess access = new KeystoneAccess();
		access.setToken(token);
		return access;
	}

	@Override
	public TenantList listTenants() {
		//List<? extends Tenant> tenants =  Arrays.asList(new KeystoneTenant("1","Tenant.1"), new KeystoneTenant("2", "Tenant 2"));
		TenantList list = new KeystoneTenantList();
		//list.setList(tenants);
		return list; 
	}

	@Override
	public Access getSessionData() {
		if(session == null) {
			session = authenticate(new KeystoneAuthentication());
		}
		return session;
	}

	@Override
	public ServiceList listServices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleList listRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service createService(Service service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant createTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTenant(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteService(String service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRole(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EndpointList listEndpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endpoint createEndpoint(Endpoint endpoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEndpoint(String id) {
		// TODO Auto-generated method stub
		
	}
	
}
