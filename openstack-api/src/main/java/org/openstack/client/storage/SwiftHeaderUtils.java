package org.openstack.client.storage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.openstack.client.common.HeadResponse;
import org.openstack.client.common.RequestBuilder;
import org.openstack.client.internals.SimpleClassInfo;
import org.openstack.client.internals.SimpleClassInfo.FieldInfo;
import org.openstack.model.storage.SwiftObjectProperties;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

class SwiftHeaderUtils {
	static final Logger log = Logger.getLogger(SwiftHeaderUtils.class.getName());

	static SimpleClassInfo classInfo;

	static SimpleClassInfo getHeaderClassInfo() {
		if (classInfo == null) {
			classInfo = new SimpleClassInfo(SwiftObjectProperties.class);
		}
		return classInfo;
	}

	public static SwiftObjectProperties unmarshalHeaders(HeadResponse response) {
		SwiftObjectProperties properties = new SwiftObjectProperties();
		Map<String, String> userProperties = properties.getCustomProperties();

		for (Entry<String, List<String>> entry : response.getHeaders().entrySet()) {
			String key = entry.getKey();
			List<String> values = entry.getValue();
			if (values.size() != 1) {
				throw new IllegalStateException();
			}
			String value = values.get(0);
			key = key.toLowerCase();

			SimpleClassInfo headerClassInfo = getHeaderClassInfo();

			String USER_PROPERTY_PREFIX = "x-object-meta-";
			if (key.startsWith(USER_PROPERTY_PREFIX)) {
				String name = key.substring(USER_PROPERTY_PREFIX.length());
				userProperties.put(name, value);
			} else {
				FieldInfo field = headerClassInfo.getField(key);

				if (field == null) {
					log.fine("Ignoring unknown header " + key);
					continue;
				}

				Object converted = field.convertToValue(value);
				field.setValue(properties, converted);
			}
		}
		return properties;
	}

	public static RequestBuilder setHeadersForProperties(RequestBuilder builder, SwiftObjectProperties changeProperties) {
		for (Map.Entry<String, String> tag : changeProperties.getCustomProperties().entrySet()) {
			builder.putHeader("x-object-meta-" + tag.getKey(), tag.getValue());
		}
		return builder;
	}

}
