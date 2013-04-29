package org.openstack.keystone.api;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.ApiAccessKeyCredentials;
import org.openstack.keystone.model.Authentication.PasswordCredentials;
import org.openstack.keystone.model.Authentication.Token;

public class TokensResource {
	
	private final OpenStackClient CLIENT;
	
	public TokensResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public Authenticate authenticate(Authentication authentication) {
		return new Authenticate(authentication);
	}

	public class Authenticate extends OpenStackRequest<Access> {
		
		private Authentication authentication;
		
		public Authenticate(Authentication authentication) {
			super(CLIENT, HttpMethod.POST, "/tokens", Entity.json(authentication), Access.class);
		}
		
		public Authenticate withPasswordCredentials(String username, String password) {
			PasswordCredentials passwordCredentials = new PasswordCredentials();
			passwordCredentials.setUsername(username);
			passwordCredentials.setPassword(password);
			authentication.setPasswordCredentials(passwordCredentials);
			return this;
		}
		
		public Authenticate withToken(String id) {
			Token token = new Token();
			token.setId(id);
			authentication.setToken(token);
			return this;
		}
		
		public Authenticate withApiAccessKeyCredentials(String accessKey, String secretKey) {
			ApiAccessKeyCredentials passwordCredentials = new ApiAccessKeyCredentials();
			passwordCredentials.setAccessKey(accessKey);
			passwordCredentials.setSecretKey(secretKey);
			authentication.setApiAccessKeyCredentials(passwordCredentials);
			return this;
		}
		
		public Authenticate withTenantId(String tenantId) {
			authentication.setTenantId(tenantId);
			return this;
		}
		
		public Authenticate withTenantName(String tenantName) {
			authentication.setTenantName(tenantName);
			return this;
		}

	}
	
}
