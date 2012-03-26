package org.openstack.ui.server;

import java.util.Properties;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;

public class LoginServiceImpl implements LoginService {

	@Override
	public KeystoneAccess login(String identityURL, String username, String password) {
		KeystoneAuthentication authentication = new KeystoneAuthentication().withPasswordCredentials(username, password);
		
		Properties properties = new Properties(); 
		
		properties.setProperty("auth.endpoint", identityURL);
		properties.setProperty("auth.username", username);
		properties.setProperty("auth.password", password);
		
		//properties.setProperty("identity.default.endpoint.adminURL","http://192.168.1.52:35357/v2.0");
		//The admintoken (setted on keystone config file)
		//properties.setProperty("identity.admin.token", "secret0");
		
		OpenStackClient openstack = OpenStackClientFactory.authenticate(properties);
		//no services when login without tenant
		IdentityAdministrationEndpoint identity = openstack.target(identityURL, IdentityAdministrationEndpoint.class);
		
		KeystoneAccess access = identity.tokens().post(authentication);
		
		KeystoneTenantList tenants = identity.tenants().get();
		
		KeystoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		access = identity.tokens().post(authentication);
		
		return access;
	}

}
