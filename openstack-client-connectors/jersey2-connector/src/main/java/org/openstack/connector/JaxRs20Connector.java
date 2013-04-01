package org.openstack.connector;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

import com.google.common.reflect.TypeToken;

public class JaxRs20Connector implements OpenStackClientConnector {

	protected Client client = OpenStack.CLIENT;

	@Override
	public <T> T execute(OpenStackRequest request, Class<T> responseType) {
		WebTarget target = client.target(request.endpoint()).path(request.path());
		target.register(new LoggingFilter(Logger.getLogger("os"),10000));
		Invocation.Builder invocation = target.request();
		for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Object v : h.getValue()) {
				sb.append(String.valueOf(v));
			}
			invocation.header(h.getKey(), sb);
		}
		if(request.entity() != null) {
			return invocation.method(request.method(), Entity.entity(request.entity().getEntity(),request.entity().getContentType()), responseType);
		} else {
			return invocation.method(request.method(), responseType);
		}
		
	}

	@Override
	public void execute(OpenStackRequest request) {
		execute(request, Response.class);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T execute(OpenStackRequest request, TypeToken<T> typeToken) {
		return (T) execute(request, typeToken.getClass());
	}
	
}
