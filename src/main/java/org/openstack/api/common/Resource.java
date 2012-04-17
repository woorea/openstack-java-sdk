package org.openstack.api.common;

import java.util.Map;
import java.util.Properties;

import javax.ws.rs.client.Target;

import com.google.common.collect.Maps;

public class Resource {
	
	protected Target target;
	protected Properties properties;
	final Map<String, Target> targets = Maps.newHashMap();
	
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
	
}
