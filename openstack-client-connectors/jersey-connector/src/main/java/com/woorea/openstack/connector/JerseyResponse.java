package com.woorea.openstack.connector;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.api.client.ClientResponse;
import com.woorea.openstack.base.client.OpenStackResponse;

public class JerseyResponse implements OpenStackResponse {

	private ClientResponse response;

	public JerseyResponse(ClientResponse response) {
		this.response = response;
	}

	@Override
	public <T> T getEntity(Class<T> returnType) {
		if(response.hasEntity() && returnType != null && Void.class != returnType) {
			return response.getEntity(returnType);
		} else {
			return null;
		}
	}

	@Override
	public InputStream getInputStream() {
		if(response.hasEntity()) {
			return response.getEntityInputStream();
		} else {
			return null;
		}
	}

	@Override
	public String header(String name) {
		return response.getHeaders().getFirst(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		for(String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaders().getFirst(k));
		}
		return headers;
	}
}
