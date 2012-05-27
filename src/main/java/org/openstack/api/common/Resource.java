package org.openstack.api.common;

import java.util.Properties;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationException;
import javax.ws.rs.client.Target;

import org.openstack.model.exceptions.OpenStackException;

public class Resource {
	
	protected Target target;
	protected Properties properties;
	
	protected Resource(Target target, Properties properties) {
		this.target = target;
		this.properties = properties;
	}

	public <T extends Resource> T path(String relativePath, Class<T> clazz) {
		//T instance = clazz.cast(resources.get(relativePath));
		T instance = null;
		if (instance == null) {
			try {
				instance = (T) clazz.getConstructor(Target.class, Properties.class).newInstance(target.path(relativePath), properties);
			} catch (Exception e) {
				throw new IllegalStateException("Error creating resource instance", e);
			}
		}
		return instance;
	}
	
	public String getURL() {
		return target.getUri().toString();
	}
	
	protected <T> T execute(Invocation invocation, Class<T> responseType) {
		try {
			return invocation.invoke(responseType);
		} catch (InvocationException e) {
			throw new OpenStackException(e.getResponse().getStatus(), e.getResponse().readEntity(String.class),e);
		}
	}
	
}
