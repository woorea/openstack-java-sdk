package org.openstack.connector;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.base.client.OpenStackResponseException;

public class JaxRs20Connector implements OpenStackClientConnector {

	protected Client client = OpenStack.CLIENT;

	@Override
	public <T> T execute(OpenStackRequest<T> request) {
		WebTarget target = client.target(request.endpoint()).path(request.path());
		for(Map.Entry<String, Object> entry : request.queryParams().entrySet()) {
			target = target.queryParam(entry.getKey(), entry.getValue());
		}
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
				if (request.returnType() == null || request.returnType() == Void.class) {
					invocation.method(request.method().name(), entity);
				} else {
					return invocation.method(request.method().name(), entity, request.returnType());
				}
			} else {
				if (request.returnType() == null || request.returnType() == Void.class) {
					invocation.method(request.method().name());
				} else {
					return invocation.method(request.method().name(), request.returnType());
				}
			}
		} catch (ClientErrorException e) {
			throw new OpenStackResponseException(e.getResponse()
					.getStatusInfo().toString(), e.getResponse().getStatus());
		}

		return null;
	}

}
