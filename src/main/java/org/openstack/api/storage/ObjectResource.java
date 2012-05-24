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

import org.apache.commons.io.IOUtils;
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

	public Response put(File srcFile, Map<String, String> properties) throws OpenStackException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(srcFile);
			return put(fis, srcFile.length(), properties);
		} catch(IOException e) {
			throw new OpenStackException(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(fis);
		}
	}
	
	public Response put(File srcFile) throws OpenStackException {
		return put(srcFile, null);
	}

	public Response put(InputStream objectStream, long objectStreamLength, Map<String, String> properties) throws OpenStackException {
		//Preconditions.checkNotNull(properties, "You have to supply object name");
		try {
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			
			byte[] bytes = IOUtils.toByteArray(objectStream);
			
			builder = builder.header("Content-Length", bytes.length);
			
			if(properties != null) {
				for(String name : properties.keySet()) {
					builder = builder.header("x-object-meta-" + name, properties.get(name));
				}
				String contentType = properties.get("Content-Type") != null ? properties.get("Content-Type") : MediaType.APPLICATION_OCTET_STREAM;
				return builder.put(Entity.entity(bytes, contentType), Response.class);
			} else {
				return builder.put(Entity.entity(bytes, MediaType.APPLICATION_OCTET_STREAM), Response.class);
			}
				
			/*
			MultivaluedMap<String, String> responseHeaders = response.getHeaders().asMap();

			SwiftObjectProperties responseProperties = new SwiftObjectProperties();
			String etag = responseHeaders.getFirst("ETag");

			if (etag != null) {
				responseProperties.setETag(etag);
			}
			return responseProperties;
			*/
		} catch(IOException e) {
			throw new OpenStackException(e.getMessage(), e);
		}
	}
	
	public Response put(InputStream objectStream, long objectStreamLength) {
		return put(objectStream, objectStreamLength, null);
	}

}
