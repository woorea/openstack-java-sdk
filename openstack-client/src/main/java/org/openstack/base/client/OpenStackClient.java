package org.openstack.base.client;

import java.util.Properties;
import java.util.ServiceLoader;

public class OpenStackClient {
	
	protected String endpoint;
	
	protected OpenStackTokenProvider tokenProvider;

	protected static int AUTHENTICATION_RETRIES = 1;

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
	
	@SuppressWarnings("unchecked")
	public <T> T execute(OpenStackCommand<T> command) {
		OpenStackNotAuthorized authException = new OpenStackNotAuthorized();

		for (int i = 0; i <= AUTHENTICATION_RETRIES; i++) {
			OpenStackRequest request = command.createRequest(this);
			request.endpoint(endpoint);

			if (tokenProvider != null) {
				request.header("X-Auth-Token", tokenProvider.getToken());
			}

			try {
				return (T) connector.execute(request, request.returnType());
			} catch (OpenStackNotAuthorized e) {
				if (tokenProvider == null) {
					// when the tokenProvider is not present there is no
					// reason to retry the authentication
					throw e;
				}
				authException = e;
				tokenProvider.expireToken();
			}
		}

		throw authException;
	}

	public void property(String property, String value) {
		properties.put(property, value);
	}
	
	public void setTokenProvider(OpenStackTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}
	
}
