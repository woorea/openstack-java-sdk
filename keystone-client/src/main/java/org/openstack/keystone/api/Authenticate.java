package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.ApiAccessKeyCredentials;
import org.openstack.keystone.model.Authentication.PasswordCredentials;
import org.openstack.keystone.model.Authentication.Token;

public class Authenticate implements KeystoneCommand<Access> {
	
	private Authentication authentication;
	
	public Authenticate(Authentication authentication) {
		this.authentication = authentication;
	}
	
	public static Authenticate withPasswordCredentials(String username, String password) {
		Authentication authentication = new Authentication();
		PasswordCredentials passwordCredentials = new PasswordCredentials();
		passwordCredentials.setUsername(username);
		passwordCredentials.setPassword(password);
		authentication.setPasswordCredentials(passwordCredentials);
		return new Authenticate(authentication);
	}
	
	public static Authenticate withToken(String id) {
		Authentication authentication = new Authentication();
		Token token = new Token();
		token.setId(id);
		authentication.setToken(token);
		return new Authenticate(authentication);
	}
	
	public static Authenticate withApiAccessKeyCredentials(String accessKey, String secretKey) {
		Authentication authentication = new Authentication();
		ApiAccessKeyCredentials passwordCredentials = new ApiAccessKeyCredentials();
		passwordCredentials.setAccessKey(accessKey);
		passwordCredentials.setSecretKey(secretKey);
		authentication.setApiAccessKeyCredentials(passwordCredentials);
		return new Authenticate(authentication);
	}
	
	public Authenticate withTenantId(String tenantId) {
		authentication.setTenantId(tenantId);
		return this;
	}
	
	public Authenticate withTenantName(String tenantName) {
		authentication.setTenantName(tenantName);
		return this;
	}

	@Override
	public Access execute(WebTarget target) {
		return target.path("/tokens").request(MediaType.APPLICATION_JSON).post(Entity.json(authentication), Access.class);
	}

}
