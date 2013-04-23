package org.openstack.connector;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackNotAuthorized;
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

		Entity<?> entity = (request.entity() == null) ? null : Entity
				.entity(request.entity().getEntity(), request.entity()
						.getContentType());

		try {
			if (entity != null) {
				if (responseType == null) {
					invocation.method(request.method().name(), entity);
				} else {
					return invocation.method(request.method().name(), entity, responseType);
				}
			} else {
				if (responseType == null) {
					invocation.method(request.method().name());
				} else {
					return invocation.method(request.method().name(), responseType);
				}
			}
		} catch (NotAuthorizedException e) {
			throw new OpenStackNotAuthorized();
		}

		return null;
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
