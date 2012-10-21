package org.openstack.common.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.OpenStack;

public class AbstractOpenStackClient {

	protected String endpointURL;
	
	protected String token;
	
	protected ClientRequestFilter tokenFilter = new ClientRequestFilter() {
		
		@Override
		public void filter(ClientRequestContext requestContext) throws IOException {
			requestContext.getHeaders().putSingle("X-Auth-Token", token);
		}
	};

	public AbstractOpenStackClient(String endpointURL, String token) {
		this.endpointURL = endpointURL;
		this.token = token;
	}
	
	public AbstractOpenStackClient(String endpointURL) {
		this(endpointURL, null);
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	public OpenStackRequest request(String uri, String... mediaTypes) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.configuration().register(tokenFilter);
		}
		return new OpenStackRequest(endpoint.path(uri).request(mediaTypes));
	}
	
	public OpenStackRequest request(String uri) {
		return request(uri, MediaType.APPLICATION_JSON);
	}
	
	public static class OpenStackRequest {
		
		private Builder builder;
		
		private OpenStackRequest(Builder builder) {
			this.builder = builder;
		}
		
		public <ResponseType> ResponseType execute(String method, Class<ResponseType> type) {
			return builder.method(method, type);
		}
		
		public <RequestType, ResponseType> ResponseType execute(String method, Entity<RequestType> data, Class<ResponseType> type) {
			return builder.method(method, data, type);
		}
		
		public void execute(String method) {
			builder.method(method);
		}
		
		public <RequestType> void execute(String method, Entity<RequestType> data) {
			builder.method(method, data, Void.class);
		}
		
	}

}
