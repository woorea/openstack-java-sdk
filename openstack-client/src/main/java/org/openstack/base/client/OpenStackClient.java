package org.openstack.base.client;

import java.util.Properties;

public class OpenStackClient {
	
	protected String endpoint;
	
	protected String token;

	protected OpenStackClientConnector connector;
	
	protected Properties properties = new Properties();
	
	public OpenStackClient(String endpoint, OpenStackClientConnector connector) {
		this.endpoint = endpoint;
		this.connector = connector;
	}
	
	public <T> T execute(OpenStackCommand<T> command) {
		OpenStackRequest request = newOpenStackRequest();
		return command.execute(connector, request);
	}

	public void property(String property, String value) {
		properties.put(property, value);
	}
	
	public void token(String token) {
		this.token = token;
	}
	
	protected OpenStackRequest newOpenStackRequest() {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		if(token != null) {
			request.header("X-Auth-Token", token);
		}
		return request;
	}
	
}