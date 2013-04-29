package org.openstack.base.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
	
	private Entity entity;
	
	private Class<R> returnType;
	
	public OpenStackRequest endpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}
	
	public String endpoint() {
		return endpoint;
	}

	public OpenStackRequest method(HttpMethod method) {
		this.method = method;
		return this;
	}
	
	public HttpMethod method() {
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
	
	public <T> Entity entity(T entity, String contentType) {
		return new Entity<T>(entity, contentType);
	}
	
	public Entity<?> entity() {
		return entity;
	}
	
	public <T> Entity json(T entity) {
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
	
}
