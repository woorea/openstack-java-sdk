package org.openstack.api.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.openstack.model.storage.swift.SwiftStorageObjectProperties;

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
	
	public Response post(StorageObjectProperties changeProperties) {
		Invocation.Builder b = target.request(MediaType.APPLICATION_JSON);
		SwiftHeaderUtils.setHeadersForProperties(b, changeProperties);
		return b.method("POST");
	}
	
	public Response delete() {
		return target.request(MediaType.WILDCARD).delete();
	}

	public InputStream openStream() {
		return target.request(MediaType.APPLICATION_OCTET_STREAM).get(InputStream.class);	
	}
	
	public Response put() throws OpenStackException {
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
		builder = builder.header("Content-Length", "0");
		return builder.put(Entity.entity(new byte[1], "application/directory"));
	}

	public Response put(File srcFile, SwiftStorageObjectProperties properties) throws OpenStackException {
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

	public Response put(InputStream objectStream, long objectStreamLength, SwiftStorageObjectProperties properties) throws OpenStackException {
		Preconditions.checkNotNull(properties, "You have to supply object propeties");
		Preconditions.checkNotNull(properties, "You have to supply object name");
		try {
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			
			byte[] bytes = IOUtils.toByteArray(objectStream);
			
			builder = builder.header("Content-Length", bytes.length);
			
			SwiftHeaderUtils.setHeadersForProperties(builder, properties);
			
			Response response = null;
			if (properties.getContentType() != null) {
				MediaType contentType = MediaType.valueOf(properties.getContentType());
				response = builder.put(Entity.entity(bytes, contentType), Response.class);
			} else {
				response = builder.put(Entity.entity(bytes, MediaType.APPLICATION_OCTET_STREAM_TYPE), Response.class);
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
			return response;
		} catch(IOException e) {
			throw new OpenStackException(e.getMessage(), e);
		}
	}

}
