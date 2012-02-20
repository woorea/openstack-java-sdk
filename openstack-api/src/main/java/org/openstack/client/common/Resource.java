package org.openstack.client.common;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.openstack.client.imagestore.UrlUtils;

import com.google.common.collect.Maps;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class Resource {

	protected OpenstackSession session;
	protected String resource;

	public Resource(OpenstackSession session, String resource) {
		this.session = session;
		this.resource = resource;
	}

	protected Resource() {
	}

	protected Builder addAcceptHeaders(WebResource webResource) {
		return webResource.accept(MediaType.APPLICATION_XML);
	}

	public void initialize(OpenstackSession session, String resource) {
		if (this.session != null)
			throw new IllegalStateException("Double initialization");
		this.session = session;
		this.resource = resource;
	}

	protected Builder resource() {
		WebResource builder = session.resource(resource);
		return addAcceptHeaders(builder);
	}

	protected Builder resource(String relativePath) {
		String resourceUrl = UrlUtils.join(resource, relativePath);
		WebResource builder = session.resource(resourceUrl);
		return addAcceptHeaders(builder);
	}

	final Map<String, Resource> resources = Maps.newHashMap();

	protected <T extends Resource> T getChildResource(String relativePath, Class<T> clazz) {
		T instance = (T) resources.get(relativePath);
		if (instance == null) {
			instance = buildChildResource(relativePath, clazz);
		}
		return instance;
	}

	protected <T extends Resource> T buildChildResource(String relativePath, Class<T> clazz) {
		T instance = (T) resources.get(relativePath);
		try {
			instance = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalStateException("Error creating resource instance", e);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException("Error creating resource instance", e);
		}
		String childResourcePath = UrlUtils.join(resource, relativePath);
		instance.initialize(session, childResourcePath);
		return instance;
	}
	
}
