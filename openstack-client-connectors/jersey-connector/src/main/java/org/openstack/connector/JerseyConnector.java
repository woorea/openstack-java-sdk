package org.openstack.connector;

import java.util.List;
import java.util.Map;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class JerseyConnector implements OpenStackClientConnector {
	
	protected Client client = Client.create();

	@Override
	public <T> T execute(OpenStackRequest<T> request) {
		WebResource target = client.resource(request.endpoint()).path(request.path());
		target.addFilter(new LoggingFilter());
		
		WebResource.Builder tb = target.getRequestBuilder();
		for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Object v : h.getValue()) {
				sb.append(String.valueOf(v));
			}
			tb.header(h.getKey(), sb);
		}
		
		return tb.get(request.returnType());
	}

}
