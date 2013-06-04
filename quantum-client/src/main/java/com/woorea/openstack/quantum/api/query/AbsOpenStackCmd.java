package com.woorea.openstack.quantum.api.query;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.woorea.openstack.base.client.OpenStackRequest;

public class AbsOpenStackCmd<T> extends OpenStackRequest<T> {

	private T query;

	protected AbsOpenStackCmd(T query)
	{
		this.setQuery(query);
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(T query) {
		this.query = query;
	}

	/**
	 * @return the query
	 */
	public T getQuery() {
		return query;
	}

	private String getFieldValue(Field field, T target)
	{
		try {
			field.setAccessible(true);
			Object obj = field.get(target);
			if (obj == null)
				return null;
			return obj.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Map<String, String> getObjectParamMap(T target)
	{
		Map<String, String> resultMap = new HashMap<String, String>();
		if (target == null)
			return resultMap;

		Field[] paramMap = target.getClass().getDeclaredFields();
		for (Field field : paramMap) {
			String resultName = field.getName();
			String value = getFieldValue(field, target);
			if (value != null) {
				JsonProperty prop = field.getAnnotation(JsonProperty.class);
				if (prop != null) {
					resultMap.put(prop.value(), getFieldValue(field, target));
				} else {
					resultMap.put(resultName, getFieldValue(field, target));
				}
			}
		}

		return resultMap;
	}

	/*
	public WebTarget queryParam(WebTarget target) {
		Map<String, String> map = getObjectParamMap(this.query);
		for (String fieldName : map.keySet()) {
			target = target.queryParam(fieldName, map.get(fieldName));
		}
		return target;
	}
	*/

}
