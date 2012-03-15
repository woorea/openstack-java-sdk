package org.openstack.client.common;

import java.io.Serializable;

public class OpenstackCredentials implements Serializable {
	private static final long serialVersionUID = 1L;

	final String authUrl;
	final String username;
	final String password;
	final String tenant;

	public OpenstackCredentials(String authUrl, String username, String password, String tenant) {
		this.authUrl = authUrl;
		this.username = username;
		this.password = password;
		this.tenant = tenant;
	}

//	public OpenstackCredentials(String authUrl, String username, String password) {
//		this(authUrl, username, password, null);
//	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getTenant() {
		return tenant;
	}

	public String getAuthUrl() {
		return authUrl;
	}
	
	public OpenstackCredentials withTenant(String tenant) {
		return new OpenstackCredentials(authUrl, username, password, tenant);
	}

	@Override
	public String toString() {
		return "OpenstackCredentials [authUrl=" + authUrl + ", username="
				+ username + ", password=" + password + ", tenant=" + tenant
				+ "]";
	}
}
