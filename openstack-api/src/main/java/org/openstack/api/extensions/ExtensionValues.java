package org.openstack.api.extensions;

import java.util.Map;

import com.google.common.collect.Maps;

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
