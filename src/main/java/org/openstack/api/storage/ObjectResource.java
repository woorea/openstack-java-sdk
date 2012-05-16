package org.openstack.api.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.RequestHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Link.Builder;

import org.apache.commons.io.IOUtils;
import org.openstack.api.common.Resource;
import org.openstack.api.identity.admin.resources.TenantResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.model.storage.StorageObjectProperties;
import org.openstack.model.storage.swift.SwiftStorageObject;
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
		int httpStatus = response.getStatus();
		if (httpStatus == 200) {
			StorageObjectProperties properties = SwiftHeaderUtils.unmarshalHeaders(response.getHeaders());
			return properties;
		}

		if (httpStatus == 404) {
			throw new OpenstackNotFoundException("Object not found");
		}

		throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
		
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
	
	public Response put() throws OpenstackException {
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
		builder = builder.header("Content-Length", "0");
		return builder.put(Entity.entity(new byte[1], "application/directory"));
	}

	public Response put(File srcFile, SwiftStorageObjectProperties properties) throws OpenstackException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(srcFile);
			return put(fis, srcFile.length(), properties);
		} catch(IOException e) {
			throw new OpenstackException(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(fis);
		}
	}

	public Response put(InputStream objectStream, long objectStreamLength, SwiftStorageObjectProperties properties) throws OpenstackException {
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
			throw new OpenstackException(e.getMessage(), e);
		}
	}

}
