package com.woorea.openstack.connector;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackResponseException;

public class JaxRs20Response implements OpenStackResponse {
	
	private Response response;
	
	public JaxRs20Response(Response response) {
		this.response = response;
	}

	@Override
	public <T> T getEntity(Class<T> returnType) {
		if(response.getStatus() >= 400) {
			throw new OpenStackResponseException(response.getStatusInfo().getReasonPhrase(),
					response.getStatusInfo().getStatusCode());
		}
		return response.readEntity(returnType);
	}

	@Override
	public InputStream getInputStream() {
		return (InputStream) response.getEntity();
	}

	@Override
	public String header(String name) {
		return response.getHeaderString(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		for(String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaderString(k));
		}
		return headers;
	}

}
