package org.openstack.base.client;

import java.util.Properties;
import java.util.ServiceLoader;

public class OpenStackClient {
	
	protected String endpoint;
	
	protected String token;

	protected OpenStackClientConnector connector;
	
	protected Properties properties = new Properties();
	
	protected static OpenStackClientConnector DEFAULT_CONNECTOR;

	static {
		ServiceLoader<OpenStackClientConnector> connectorLoader;
		connectorLoader = ServiceLoader.load(OpenStackClientConnector.class);

		for (OpenStackClientConnector clientConnector : connectorLoader) {
			DEFAULT_CONNECTOR = clientConnector;
			break;
		}
	}

	public OpenStackClient(String endpoint) {
		this.endpoint = endpoint;
		this.connector = DEFAULT_CONNECTOR;
	}

	public OpenStackClient(String endpoint, OpenStackClientConnector connector) {
		this.endpoint = endpoint;
		this.connector = (connector == null) ? DEFAULT_CONNECTOR : connector;
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
	
	public OpenStackRequest newOpenStackRequest() {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		if(token != null) {
			request.header("X-Auth-Token", token);
		}
		return request;
	}
	
}