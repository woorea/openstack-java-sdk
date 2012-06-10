package org.openstack.api.authentication;

import java.util.Properties;

import org.openstack.model.identity.keystone.KeystoneAuthentication;

public class KeystoneAuthenticationProvider extends AuthenticationProvider {

	public Properties authenticate(Properties properties) {
		
		String credentials = properties.getProperty("auth.credentials");
		
		KeystoneAuthentication authentication = null;
		
		if("apiAccessKeyCredentials".equals(credentials)) {
			String accessKey = properties.getProperty("auth.accessKey");
			String secretKey = properties.getProperty("auth.secretKey");
			authentication = KeystoneAuthentication.withApiAccessKeyCredentials(accessKey, secretKey);
		} else {
			String username = properties.getProperty("auth.username");
			String password = properties.getProperty("auth.password");
			authentication = KeystoneAuthentication.withPasswordCredentials(username, password);
		}
		
		String tenantId = properties.getProperty("auth.tenantId");
		String tenantName = properties.getProperty("auth.tenantName");
		
		if(tenantId != null) {
			authentication.setTenantId(tenantId);
		} else if(tenantName != null) {
			authentication.setTenantName(tenantName);
		}
		//Access access = client.getIdentityEndpoint().tokens().post(authentication);
		return properties;
	}
	
}
