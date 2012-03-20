package org.openstack.api.common;

import java.util.Map;

import javax.ws.rs.client.Target;

import com.google.common.collect.Maps;

public class Resource {
	
	protected Target target;
	final Map<String, Target> targets = Maps.newHashMap();
	
	protected Resource(Target target) {
		this.target = target;
	}

	public <T extends Resource> T path(String relativePath, Class<T> clazz) {
		//T instance = clazz.cast(resources.get(relativePath));
		T instance = null;
		if (instance == null) {
			try {
				instance = (T) clazz.getConstructor(Target.class).newInstance(target.path(relativePath));
			} catch (Exception e) {
				throw new IllegalStateException("Error creating resource instance", e);
			}
		}
		return instance;
	}
	
}
