package org.openstack.common.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

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

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
