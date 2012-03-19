package org.openstack.api.common;

import java.net.URLEncoder;
import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.imagestore.UrlUtils;
import org.openstack.client.OpenStackSession;
import org.openstack.client.RequestBuilder;

import com.google.common.collect.Maps;

public class Resource {
	
	protected Target target;
	final Map<String, Target> targets = Maps.newHashMap();

	protected OpenStackSession session;
	protected String resource;
	
	final Map<String, Resource> resources = Maps.newHashMap();

	public Resource(OpenStackSession session, String resource) {
		this.session = session;
		this.resource = resource;
	}

	protected Resource() {
	}
	
	protected Resource(Target target) {
		this.target = target;
	}

	protected MediaType getDefaultContentType() {
		return MediaType.APPLICATION_XML_TYPE;
	}

	protected void initialize(OpenStackSession session, String resource) {
		if (this.session != null)
			throw new IllegalStateException("Double initialization");
		
		this.session = session;
		this.resource = resource;
	}

	protected RequestBuilder resource() {
		return resource(null, null);
	}

	protected RequestBuilder resource(String relativePath) {
		return resource(relativePath, null);
	}

	protected RequestBuilder resource(String relativePath, MediaType contentType) {
		String resourceUrl = relativePath != null ? UrlUtils.join(resource, relativePath) : resource;
		RequestBuilder request = session.resource(resourceUrl);

		MediaType forceContentType = session.getForceContentType();

		if (forceContentType != null) {
			// Only force the contentType if it is XML, JSON, or unspecified
			// (e.g. don't change the content type on a glance image upload!)
			if (contentType == null || contentType == MediaType.APPLICATION_JSON_TYPE
					|| contentType == MediaType.APPLICATION_XML_TYPE) {
				contentType = forceContentType;
			}
		}

		if (contentType == null) {
			contentType = getDefaultContentType();
		}

		request.addAcceptType(contentType);
		if (contentType == MediaType.APPLICATION_JSON_TYPE || contentType == MediaType.APPLICATION_XML_TYPE) {
			// Assume we're going to be posting the same type (for now!)
			request.setContentType(contentType);
		}

		return request;
	}

	

	protected <T extends Resource> T getChildResource(String relativePath, Class<T> clazz) {
		T instance = (T) resources.get(relativePath);
		if (instance == null) {
			instance = buildChildResource(relativePath, clazz);
		}
		return instance;
	}
	
	protected <T extends Resource> T target(String relativePath, Class<T> clazz) {
		T instance = clazz.cast(resources.get(relativePath));
		if (instance == null) {
			try {
				instance = (T) clazz.getConstructor(Target.class).newInstance(target.path(relativePath));
			} catch (Exception e) {
				throw new IllegalStateException("Error creating resource instance", e);
			}
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

		// TODO: Make this encoding less of a hack
		String encoded = relativePath;
		encoded = URLEncoder.encode(encoded);
		encoded = encoded.replace("+", "%20");
		encoded = encoded.replace("%2F", "/");

		String childResourcePath = UrlUtils.join(resource, encoded);
		instance.initialize(session, childResourcePath);
		return instance;
	}
	
	protected <T extends Resource> T resource(Map<String, Object> properties, Class<T> resourceClass) {
		return resourceClass.cast(this);
	}

}
