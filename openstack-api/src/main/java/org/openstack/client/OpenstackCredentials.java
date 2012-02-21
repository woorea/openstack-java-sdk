package org.openstack.client;

public class OpenstackCredentials {
	final String username;
	final String password;
	String tenant;

	public OpenstackCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public OpenstackCredentials(String username, String password, String tenant) {
		this(username, password);
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

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

}
