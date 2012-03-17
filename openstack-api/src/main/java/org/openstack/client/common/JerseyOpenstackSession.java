package org.openstack.client.common;

import java.util.Map.Entry;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;

public class JerseyOpenstackSession extends OpenStackSession {

	private static final long serialVersionUID = 1L;

	@Override
	protected RequestBuilder createRequestBuilder(String resourceUrl) {
		return new JerseyRequestBuilder(resourceUrl);
	}

	public class JerseyRequestBuilder extends RequestBuilder {

		public JerseyRequestBuilder(String resourceUrl) {
			super(JerseyOpenstackSession.this, resourceUrl);
		}

		@Override
		public <T> T doRequest0(Class<T> c) {
			Builder builder = buildResource();

			if (c == Void.class) {
				if (body != null) {
					builder.method(method, Entity.xml(body));
				} else {
					builder.method(method);
				}
				return null;
			} else {
				if (body != null) {
					return builder.method(method, Entity.xml(body), c);
				} else {
					return builder.method(method, c);
				}
			}
		}

		private Invocation.Builder buildResource() {
			Invocation.Builder builder = null;
			javax.ws.rs.client.Client jerseyClient = RestClient.INSTANCE
					.getJerseyClient();
			Target target = jerseyClient.target(resourceUrl);
			target.configuration().register(
					OpenstackExceptionClientFilter.class);
			if (verbose) {
				target.configuration().register(new LoggingFilter());
			}
			System.out.println(">>>>" + resourceUrl);

			if (!queryParameters.isEmpty()) {
				MultivaluedMap<String, Object> queryParametersMap = new MultivaluedHashMap<String, Object>();
				for (Entry<String, String> entry : queryParameters.entries()) {
					queryParametersMap.add(entry.getKey(), entry.getValue());
				}
				target = target.queryParams(queryParametersMap);
			}

			builder = target.request(acceptTypes.toArray(new MediaType[0]));

			for (Entry<String, String> entry : headers.entrySet()) {
				builder = builder.header(entry.getKey(), entry.getValue());
			}
			
			return builder;
		}

		@Override
		public HeadResponse head() {
			Builder builder = buildResource();

			Response head = builder.head();
			return new HeadResponse(head.getStatus(), head.getHeaders());
		}

	}

}
