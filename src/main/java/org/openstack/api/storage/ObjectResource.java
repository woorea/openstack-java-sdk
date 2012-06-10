package org.openstack.api.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.admin.resources.TenantResource;
import org.openstack.model.exceptions.OpenStackException;
import org.openstack.model.storage.StorageObjectProperties;

import com.google.common.base.Preconditions;

public class ObjectResource  extends Resource {
	
	// Storage Objects
	// Verb URI Description
	// GET /account/container/object Retrieve object
	// PUT /account/container/object Create/Update Object
	// PUT /account/container/object Chunked transfer encoding
	// DELETE /account/container/object Delete container
	// HEAD /account/container/object Retrieve object metadata
	// POST /account/container/object Update object metadata
	
	private TenantResource t = null; //new TenantResource();
	
	
	public ObjectResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public StorageObjectProperties head() {
		Response response = target.request(MediaType.APPLICATION_JSON).head();
		StorageObjectProperties properties = SwiftHeaderUtils.unmarshalHeaders(response.getHeaders());
		return properties;
	}
	
	public Response post(Properties properties) {
		Preconditions.checkNotNull(properties, "You have to supply properties");
		Invocation.Builder b = target.request(MediaType.APPLICATION_JSON);
		for(String name : properties.stringPropertyNames()) {
			b = b.header("x-object-meta-" + name, properties.getProperty(name));
		}
		return b.method("POST");
	}
	
	public Response delete() {
		return target.request(MediaType.WILDCARD).delete();
	}

	public <T> T get(Class<T> c) {
		return target.request(MediaType.WILDCARD).get(c);	
	}
	
	public Response put() throws OpenStackException {
		Invocation.Builder builder = target.request();
		builder = builder.header("Content-Length", 0);
		return builder.put(Entity.entity(new byte[1],"application/directory"));
	}
	
	public Response put(InputStream is, Map<String, String> headers) throws OpenStackException {
		Invocation.Builder builder = target.request(MediaType.WILDCARD);
		if(headers != null) {
			for(Map.Entry<String, String> entry : headers.entrySet()) {
				builder = builder.header("x-object-meta-"+entry.getKey(), entry.getValue());
			}
		}
		long start = System.currentTimeMillis();
		Response response = builder.put(Entity.entity(is, MediaType.APPLICATION_OCTET_STREAM));
		long end = System.currentTimeMillis();
		System.out.println("TIME : " + (end - start));
		return response;
		/*
		try {
			Map<String, String> swiftHeaders = new HashMap<String, String>();
			for(Map.Entry<String, String> entry : headers.entrySet()) {
				swiftHeaders.put("x-object-meta-"+entry.getKey(), entry.getValue());
			}
			swiftHeaders.put("X-Auth-Token", properties.getProperty("auth.token"));
			HttpUtils.upload("PUT", target.getUri().toURL(), swiftHeaders, is);
			return null;
		} catch (IOException e) {
			throw new OpenStackException(e.getMessage(), e);
		}
		*/
	}

	public Response put(File file, Map<String, String> headers) throws OpenStackException {
		try {
			return put(new FileInputStream(file), headers);
		} catch (IOException e) {
			throw new OpenStackException(e.getMessage(), e);
		}
		
	}
	
	public Response put(File file) throws OpenStackException {
		return put(file, null);
	}
	
	public Response put(InputStream objectStream) {
		return put(objectStream, null);
	}

}
