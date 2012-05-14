package org.openstack.api.storage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.ResponseHeaders;

import org.openstack.model.storage.StorageObjectProperties;
import org.openstack.model.storage.swift.SwiftStorageObjectProperties;

class SwiftHeaderUtils {
	
	static final Logger log = Logger.getLogger(SwiftHeaderUtils.class.getName());

	
	public static StorageObjectProperties unmarshalHeaders(ResponseHeaders response) {
		
		StorageObjectProperties properties = new SwiftStorageObjectProperties();
		
		Map<String, String> userProperties = properties.getCustomProperties();

		for (Entry<String, List<String>> entry : response.asMap().entrySet()) {
			String key = entry.getKey();
			List<String> values = entry.getValue();
			if (values.size() != 1) {
				throw new IllegalStateException();
			}
			String value = values.get(0);
			key = key.toLowerCase();

			String USER_PROPERTY_PREFIX = "x-object-meta-";
			if (key.startsWith(USER_PROPERTY_PREFIX)) {
				String name = key.substring(USER_PROPERTY_PREFIX.length());
				userProperties.put(name, value);
			} else {
				
			}
		}
		
		return properties;
	}
	
	public static Invocation.Builder setHeadersForProperties(Invocation.Builder builder, StorageObjectProperties changeProperties) {
		
		for (Map.Entry<String, String> tag : changeProperties.getCustomProperties().entrySet()) {
			builder.header("x-object-meta-" + tag.getKey(), tag.getValue());
		}
		return builder;
	}

}
