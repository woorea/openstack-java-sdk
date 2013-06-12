package com.woorea.openstack.base.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class OpenStackRequest<R> {
	
	private OpenStackClient client;
	
	public OpenStackRequest() {
		
	}
	
	public OpenStackRequest(OpenStackClient client, HttpMethod method, String path, Entity<?> entity, Class<R> returnType) {
		this.client = client;
		this.method = method;
		this.path = new StringBuilder(path);
		this.entity = entity;
		this.returnType = returnType;
		header("Accept", "application/json");
	}
	
	private String endpoint;
	
	private HttpMethod method;
	
	private StringBuilder path = new StringBuilder();
	
	private Map<String, List<Object>> headers = new HashMap<String, List<Object>>();
	
	private Entity<?> entity;
	
	private Class<R> returnType;
	
	public OpenStackRequest<R> endpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}
	
	public String endpoint() {
		return endpoint;
	}

	public OpenStackRequest<R> method(HttpMethod method) {
		this.method = method;
		return this;
	}
	
	public HttpMethod method() {
		return method;
	}
	
	public OpenStackRequest<R> path(String path) {
		this.path.append(path);
		return this;
	}
	
	public String path() {
		return path.toString();
	}

	public OpenStackRequest<R> header(String name, Object value) {
		if(value != null) {
			headers.put(name, Arrays.asList(value));
		}
		return this;
	}
	
	public Map<String, List<Object>> headers() {
		return headers;
	}
	
	public <T> Entity<T> entity(T entity, String contentType) {
		return new Entity<T>(entity, contentType);
	}
	
	public Entity<?> entity() {
		return entity;
	}
	
	public <T> Entity<T> json(T entity) {
		return entity(entity, "application/json");
	}
	
	public void returnType(Class<R> returnType) {
		this.returnType = returnType;
	}
	
	public Class<R> returnType() {
		return returnType;
	}
	
	public R execute() {
		return client.execute(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OpenStackRequest [endpoint=" + endpoint + ", method=" + method
				+ ", path=" + path + ", headers=" + headers + ", entity="
				+ entity + ", returnType=" + returnType + "]";
	}

	private Map<String, List<Object> > queryParams = new LinkedHashMap<String, List<Object> >();

	public Map<String, List<Object> > queryParams() {
		return queryParams;
	}

	public OpenStackRequest<R> queryParam(String key, Object value) {
		if (queryParams.containsKey(key)) {
			List<Object> values = queryParams.get(key);
			values.add(value);
		} else {
			List<Object> values = new ArrayList<Object>();
			values.add(value);
			queryParams.put(key, values);
		}

		return this;
    }
	
	protected static String buildPath(String ... elements) {
	    StringBuilder stringBuilder = new StringBuilder();
	    for (String element : elements) {
            stringBuilder.append(element);
        }

	    return stringBuilder.toString();
	}
}
