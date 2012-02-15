package org.openstack.client.extensions;

import java.util.Map;

import com.fathomdb.Casts;

public class ExtensionValues {

    private final Map<Class<?>, Object> results;

    public ExtensionValues(Map<Class<?>, Object> results) {
        this.results = results;
    }

    public <T> T get(Class<T> clazz) {
        return Casts.checkedCast(results.get(clazz), clazz);
    }
}
