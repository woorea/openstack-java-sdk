package com.woorea.openstack.keystone.model.authentication;

import org.codehaus.jackson.map.annotate.JsonRootName;

import com.woorea.openstack.keystone.model.Authentication;

@JsonRootName("auth")
public class TokenAuthentication extends Authentication {
	
	public static final class Token {
		
		private String id;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		
	}
	
	private Token token = new Token();
	
	public TokenAuthentication(String token) {
		this.token.id = token;
	}

	/**
	 * @return the token
	 */
	public Token getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(Token token) {
		this.token = token;
	}
	
}
