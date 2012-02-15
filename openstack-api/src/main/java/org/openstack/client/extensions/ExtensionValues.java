package org.openstack.client.extensions;

import java.util.Map;

import org.testng.collections.Maps;

public class ExtensionValues {

	final Map<Class<?>, Object> results = Maps.newHashMap();

	public ExtensionValues() {
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz) {
		return (T) results.get(clazz);
	}

	public void add(Object o) {
		results.put(o.getClass(), o);
	}
}
