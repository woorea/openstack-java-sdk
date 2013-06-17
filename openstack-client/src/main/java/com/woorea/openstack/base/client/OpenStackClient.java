package com.woorea.openstack.base.client;

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

	public <T> OpenStackResponse request(OpenStackRequest<T> request) {
		OpenStackResponseException authException = null;

		for (int i = 0; i <= AUTHENTICATION_RETRIES; i++) {
			request.endpoint(endpoint);

			if (tokenProvider != null) {
				request.header("X-Auth-Token", tokenProvider.getToken());
			}

			try {
				return connector.request(request);
			} catch (OpenStackResponseException e) {
				if (e.getStatus() != OpenStackResponseStatus.NOT_AUTHORIZED
						|| tokenProvider == null) {
					throw e;
				}
				authException = e;
				tokenProvider.expireToken();
			}
		}

		throw authException;
	}

	public <T> T execute(OpenStackRequest<T> request) {
		OpenStackResponse response =  request(request);
		return (request.returnType() != null && request.returnType() != Void.class) ? response.getEntity(request.returnType()) : null;
	}

	public void property(String property, String value) {
		properties.put(property, value);
	}
	
	public void setTokenProvider(OpenStackTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}
	
	public void token(String token) {
		setTokenProvider(new OpenStackSimpleTokenProvider(token));
	}
	
}
