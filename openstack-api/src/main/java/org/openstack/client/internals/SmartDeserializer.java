package org.openstack.client.internals;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.openstack.client.internals.SimpleClassInfo.FieldInfo;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.Addresses.Network;
import org.openstack.model.compute.Addresses.Network.Ip;

import com.google.common.collect.Lists;

public class SmartDeserializer<T> extends StdDeserializer<T> {
	final Class<T> clazz;
	private SimpleClassInfo classInfo;

	public SmartDeserializer(Class<T> clazz) {
		super(clazz);
		this.clazz = clazz;
		this.classInfo = SimpleClassInfo.get(clazz);
	}

	@Override
	public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		T t = newInstance(clazz);

		JsonToken token = jp.getCurrentToken();
		if (token != JsonToken.START_OBJECT) {
			throw ctxt.wrongTokenException(jp, JsonToken.START_OBJECT, "Unexpected token");
		}

		int keyCount = 0;

		while ((token = jp.nextToken()) != JsonToken.END_OBJECT) {
			switch (token) {
			case FIELD_NAME:
				String key = jp.getText();

				FieldInfo fieldInfo = classInfo.getField(key);
				if (fieldInfo == null) {
					if (keyCount == 0) {
						if (key.equals(classInfo.getJsonName())) {
							// It looks like a wrapper field
							jp.nextToken();
							t = deserialize(jp, ctxt);
							if (JsonToken.END_OBJECT != jp.nextToken()) {
								throw ctxt.wrongTokenException(jp, JsonToken.END_OBJECT, "Expected end of object");
							}
							return t;
						}
					}
					reportUnknownProperty(ctxt, clazz, key);
					continue;
				}

				if (fieldInfo.getCollectionItemType() != null) {
					jp.nextToken();
					List list = readArray(fieldInfo, jp, ctxt);
					fieldInfo.setValue(t, list);
				} else {
					jp.nextToken();
					Class<?> valueType = fieldInfo.getValueType();
					Object o = jp.readValueAs(valueType);
					fieldInfo.setValue(t, o);
				}
				break;

			default:
				throw ctxt.wrongTokenException(jp, JsonToken.FIELD_NAME, "Unexpected token");
			}

			keyCount++;
		}

		return t;
	}

	private List readArray(FieldInfo fieldInfo, JsonParser jp, DeserializationContext ctxt)
			throws JsonProcessingException, IOException {
		Class elementClass = fieldInfo.getCollectionItemType();

		List list = Lists.newArrayList();

		JsonToken token = jp.getCurrentToken();
		if (token != JsonToken.START_ARRAY) {
			throw ctxt.wrongTokenException(jp, JsonToken.START_ARRAY, "Unexpected token");
		}

		while ((token = jp.nextToken()) != JsonToken.END_ARRAY) {
			switch (token) {
			case START_OBJECT:
				Object o = jp.readValueAs(elementClass);
				list.add(o);
				break;

			default:
				throw ctxt.wrongTokenException(jp, JsonToken.START_OBJECT, "Unexpected token");
			}
		}

		return list;
	}

	private static <T> T newInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalStateException("Error building " + clazz, e);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException("Error building " + clazz, e);
		}
	}

}
