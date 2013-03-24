package org.openstack.connector;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class JaxRs20Connector implements OpenStackClientConnector {

	protected Client client = OpenStack.CLIENT;

	@Override
	public <T> T execute(OpenStackRequest request, Class<T> responseType) {
		WebTarget target = client.target(request.endpoint()).path(request.path());
		Invocation.Builder invocation = target.request();
		for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Object v : h.getValue()) {
				sb.append(String.valueOf(v));
			}
			invocation.header(h.getKey(), sb);
		}
		return invocation.method(request.method(), Entity.json(request.entity()), responseType);
	}

	@Override
	public void execute(OpenStackRequest request) {
		execute(request, Response.class);
		
	}
	
}
