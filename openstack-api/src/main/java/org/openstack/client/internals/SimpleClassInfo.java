package org.openstack.client.internals;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.client.internals.SimpleClassInfo.FieldInfo;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SimpleClassInfo {
	final List<FieldInfo> fields;
	final ImmutableMap<String, FieldInfo> fieldsByJsonKey;
	final Class<?> clazz;
	private String jsonName;
	private Field anyAttributeField;

	public SimpleClassInfo(Class<?> c) {
		this.clazz = c;

		discoverClassInfo();

		this.fields = discoverFields(c);

		this.fieldsByJsonKey = Maps.uniqueIndex(fields, new Function<FieldInfo, String>() {
			@Override
			public String apply(FieldInfo f) {
				return f.jsonName;
			}
		});
	}

	private void discoverClassInfo() {
		String jsonName = null;

		if (jsonName == null) {
			XmlRootElement xmlRootElement = clazz.getAnnotation(XmlRootElement.class);
			if (xmlRootElement != null) {
				jsonName = xmlRootElement.name();
				if ("##default".equals(jsonName))
					jsonName = null;
			}
		}

		if (jsonName == null) {
			jsonName = clazz.getSimpleName();
		}

		this.jsonName = jsonName;
	}

	static class FieldInfo {
		final Field field;
		final String jsonName;
		final Class<?> collectionItemType;

		public FieldInfo(Field field, String jsonName, Class<?> collectionItemType) {
			this.field = field;
			this.jsonName = jsonName;
			this.collectionItemType = collectionItemType;

			ensureAccessible();
		}

		private void ensureAccessible() {
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
		}

		public Class getCollectionItemType() {
			return collectionItemType;
		}

		public void setValue(Object target, Object value) {
			try {
				field.set(target, value);
			} catch (IllegalAccessException e) {
				throw new IllegalStateException("Error setting field value", e);
			}
		}

		public Class<?> getValueType() {
			return field.getType();
		}
	}

	private List<FieldInfo> discoverFields(Class<?> c) {
		List<FieldInfo> fields = Lists.newArrayList();

		for (Field field : c.getDeclaredFields()) {
			XmlAnyAttribute xmlAnyAttribute = field.getAnnotation(XmlAnyAttribute.class);
			if (xmlAnyAttribute != null) {
				anyAttributeField = field;
				anyAttributeField.setAccessible(true);
				continue;
			}

			String jsonName = null;

			Class<?> collectionItemType = null;

			if (jsonName == null) {
				JsonProperty annotation = field.getAnnotation(JsonProperty.class);
				if (annotation != null) {
					jsonName = annotation.value();
					if ("".equals(jsonName))
						jsonName = null;
				}
			}

			if (jsonName == null) {
				XmlElementWrapper xmlElementWrapperAnnotation = field.getAnnotation(XmlElementWrapper.class);
				if (xmlElementWrapperAnnotation != null) {
					jsonName = xmlElementWrapperAnnotation.name();
					if ("##default".equals(jsonName))
						jsonName = null;
				}
			}

			if (jsonName == null) {
				XmlElement xmlElementAnnotation = field.getAnnotation(XmlElement.class);
				if (xmlElementAnnotation != null) {
					jsonName = xmlElementAnnotation.name();
					if ("##default".equals(jsonName))
						jsonName = null;
				}
			}

			if (jsonName == null) {
				XmlAttribute xmlAttributeAnnotation = field.getAnnotation(XmlAttribute.class);
				if (xmlAttributeAnnotation != null) {
					jsonName = xmlAttributeAnnotation.name();
					if ("##default".equals(jsonName))
						jsonName = null;
				}
			}

			if (jsonName == null) {
				jsonName = field.getName();
			}

			if (field.getType() == List.class) {
				ParameterizedType listItemType = (ParameterizedType) field.getGenericType();
				collectionItemType = (Class<?>) listItemType.getActualTypeArguments()[0];
			}

			FieldInfo fieldInfo = new FieldInfo(field, jsonName, collectionItemType);
			fields.add(fieldInfo);
		}
		return fields;
	}

	static final Map<Class<?>, SimpleClassInfo> cache = Maps.newHashMap();

	public synchronized static SimpleClassInfo get(Class<?> c) {
		SimpleClassInfo info = cache.get(c);
		info = new SimpleClassInfo(c);
		cache.put(c, info);
		return info;
	}

	public FieldInfo getField(String key) {
		return fieldsByJsonKey.get(key);
	}

	public String getJsonName() {
		return jsonName;
	}

	public boolean hasAnyAttribute() {
		return anyAttributeField != null;
	}
	
	public Map<QName, Object> getAnyAttribute(Object target) {
		try {
			Map<QName, Object> map = (Map<QName, Object>) anyAttributeField.get(target);
			if (map == null) {
				anyAttributeField.set(target, map);
				map = Maps.newHashMap();
			}
			return map;
		} catch (IllegalAccessException e) {
			throw new IllegalStateException("Error getting field value", e);
		}
	}
}
