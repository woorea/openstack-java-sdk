package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.authentication.AccessKey;
import org.openstack.keystone.model.authentication.TokenAuthentication;
import org.openstack.keystone.model.authentication.UsernamePassword;

public class Authenticate extends OpenStackRequest<Access> {
	
	private Authentication authentication;
	
	public Authenticate(Authentication authentication) {
		method(HttpMethod.POST);
		path("/tokens");
		json(authentication);
		header("Accept", "application/json");
		returnType(Access.class);
	}
	
	public Authenticate withTenantId(String tenantId) {
		authentication.setTenantId(tenantId);
		return this;
	}
	
	public Authenticate withTenantName(String tenantName) {
		authentication.setTenantName(tenantName);
		return this;
	}
	
	public class Builder {
		
		public Authenticate withUsernamePassword(String username, String password) {
			authentication = new UsernamePassword(username, password);
			return Authenticate.this;
		}
		
		public Authenticate withToken(String token) {
			authentication = new TokenAuthentication(token);
			return Authenticate.this;
		}
		
		public Authenticate withAccessKey(String accessKey, String secretKey) {
			authentication = new AccessKey(accessKey, secretKey);
			return Authenticate.this;
		}
		
	}
	
}
