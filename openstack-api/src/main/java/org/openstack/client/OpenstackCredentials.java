package org.openstack.client;

public class OpenstackCredentials {
	final String username;
	final String password;
	final String tenant;

	public OpenstackCredentials(String username, String password, String tenant) {
		this.username = username;
		this.password = password;
		this.tenant = tenant;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getTenant() {
		return tenant;
	}

}
