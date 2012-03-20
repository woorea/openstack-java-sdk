package org.openstack.api.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.TenantResource;
import org.openstack.api.imagestore.KnownLengthInputStream;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.model.storage.SwiftObjectProperties;
import org.openstack.utils.Io;

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
	
	
	public ObjectResource(Target target) {
		super(target);
	}
	
	public SwiftObjectProperties head() {
		
		Response response = target.request(MediaType.APPLICATION_JSON).head();
		int httpStatus = response.getStatus();
		if (httpStatus == 200) {
			SwiftObjectProperties properties = SwiftHeaderUtils.unmarshalHeaders(response.getHeaders());
			return properties;
		}

		if (httpStatus == 404) {
			throw new OpenstackNotFoundException("Object not found");
		}

		throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
		
	}
	
	public Response post(SwiftObjectProperties changeProperties) {
		Invocation.Builder b = target.request(MediaType.APPLICATION_JSON);
		SwiftHeaderUtils.setHeadersForProperties(b, changeProperties);
		return b.method("POST");
	}
	
	public Response delete() {
		return target.request().delete();
	}

	public InputStream openStream() {
		return target.request(MediaType.APPLICATION_OCTET_STREAM).get(InputStream.class);	
	}

	public SwiftObjectProperties put(File srcFile, SwiftObjectProperties properties) throws OpenstackException, IOException {
		FileInputStream fis = new FileInputStream(srcFile);
		try {
			return put(fis, srcFile.length(), properties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public SwiftObjectProperties put(InputStream objectStream, long objectStreamLength, SwiftObjectProperties properties)
			throws OpenstackException, IOException {
		Preconditions.checkNotNull(properties, "You have to supply object propeties");
		Preconditions.checkNotNull(properties, "You have to supply object name");

		if (objectStreamLength != -1) {
			objectStream = new KnownLengthInputStream(objectStream, objectStreamLength);
		}

		Invocation.Builder builder = target.request();
		
		SwiftHeaderUtils.setHeadersForProperties(builder, properties);
		
		Response response = null;
		if (properties.getContentType() != null) {
			MediaType contentType = MediaType.valueOf(properties.getContentType());
			response = builder.put(Entity.entity(objectStream, contentType), Response.class);
		} else {
			response = builder.put(Entity.entity(objectStream, MediaType.APPLICATION_OCTET_STREAM), Response.class);
		}
		MultivaluedMap<String, String> responseHeaders = response.getHeaders().asMap();

		SwiftObjectProperties responseProperties = new SwiftObjectProperties();
		String etag = responseHeaders.getFirst("ETag");

		if (etag != null) {
			responseProperties.setETag(etag);
		}
		return responseProperties;
	}

}
