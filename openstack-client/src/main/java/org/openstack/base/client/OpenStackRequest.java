package org.openstack.base.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenStackRequest {
	
	private String endpoint;
	
	private String method;
	
	private StringBuilder path = new StringBuilder();
	
	private Map<String, List<Object>> headers = new HashMap<String, List<Object>>();
	
	private Object entity;

	public String execute(String method, String path, Class<String> responseType) {
		return null;
	}
	
	public OpenStackRequest endpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}
	
	public String endpoint() {
		return endpoint;
	}

	public OpenStackRequest method(String method) {
		this.method = method;
		return this;
	}
	
	public String method() {
		return method;
	}
	
	public OpenStackRequest path(String path) {
		this.path.append(path);
		return this;
	}
	
	public String path() {
		return path.toString();
	}

	public OpenStackRequest header(String name, Object... values) {
		headers.put(name, Arrays.asList(values));
		return this;
	}
	
	public Map<String, List<Object>> headers() {
		return headers;
	}
	
	public OpenStackRequest entity(Object entity) {
		this.entity = entity;
		return this;	
	}
	
	public Object entity() {
		return entity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OpenStackRequest [endpoint=" + endpoint + ", method=" + method
				+ ", path=" + path + ", headers=" + headers + "]";
	}

	public void json(Object entity) {
		entity(entity);
		header("Content-Type", "application/json");
	}

	

}
