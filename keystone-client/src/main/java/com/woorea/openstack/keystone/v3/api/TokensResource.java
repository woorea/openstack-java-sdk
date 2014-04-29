package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.v3.model.Authentication;
import com.woorea.openstack.keystone.v3.model.Token;

public class TokensResource {
	
	private final OpenStackClient CLIENT;
	
	public TokensResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public Authenticate authenticate(Authentication authentication) {
		return new Authenticate(authentication);
	}
	
	public OpenStackRequest<Token> show() {
		return CLIENT.get("/auth/tokens", Token.class);
	}

	public class Authenticate extends OpenStackRequest<Token> {
		
		private Authentication authentication;
		
		public Authenticate() {
			
		}
		
		public Authenticate(Authentication authentication) {
			super(CLIENT, HttpMethod.POST, "/auth/tokens", Entity.json(authentication), Token.class);
			this.authentication = authentication;
		}

	}
	
}

