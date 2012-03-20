package org.openstack.api.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request.RequestBuilder;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.api.imagestore.KnownLengthInputStream;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.storage.SwiftObjectProperties;
import org.openstack.model.storage.SwiftStorageObject;
import org.openstack.utils.Io;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;


public class ContainerResource extends Resource {
	
	public ContainerResource(Target target) {
		super(target);
	}
	
	public void delete(Map<String, Object> properties) {
		target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).delete();
	}
	
	public Iterable<SwiftStorageObject> list() {
		return list(null, null);
	}

	public List<SwiftStorageObject> list(String prefix, String delimiter) {
		
		Builder b = target.request();
		

		if (prefix != null) {
			//this.target = b.addQueryParameter("prefix", prefix);
		}
		if (!Strings.isNullOrEmpty(delimiter)) {
			//b.addQueryParameter("delimiter", delimiter);
		}

		//b.clearAcceptTypes();
		//b.addAcceptType(MediaType.TEXT_PLAIN_TYPE);

		//String listing = requestBuilder.get(String.class);
		String listing = "";
		List<SwiftStorageObject> list = Lists.newArrayList();
		for (String line : Splitter.on("\n").split(listing)) {
			if (line.isEmpty())
				continue;

			SwiftStorageObject storageObject = new SwiftStorageObject();
			storageObject.setName(line);
			list.add(storageObject);
		}

		return list;
	}

	public void addObject(File imageFile, SwiftObjectProperties properties) throws IOException, OpenstackException {
		FileInputStream fis = new FileInputStream(imageFile);
		try {
			putObject(fis, imageFile.length(), properties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public SwiftObjectProperties putObject(File srcFile, SwiftObjectProperties properties) throws OpenstackException, IOException {
		FileInputStream fis = new FileInputStream(srcFile);
		try {
			return putObject(fis, srcFile.length(), properties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public SwiftObjectProperties putObject(InputStream objectStream, long objectStreamLength, SwiftObjectProperties properties)
			throws OpenstackException, IOException {

		if (objectStreamLength != -1) {
			objectStream = new KnownLengthInputStream(objectStream, objectStreamLength);
		}

		RequestBuilder builder = buildPutRequest(properties);

		Response response = null; //builder.put(Response.class, objectStream);
		MultivaluedMap<String, String> responseHeaders = response.getHeaders().asMap();

		SwiftObjectProperties responseProperties = new SwiftObjectProperties();
		String etag = responseHeaders.getFirst("ETag");

		if (etag != null) {
			responseProperties.setETag(etag);
		}
		return responseProperties;
	}

	public RequestBuilder buildPutRequest(SwiftObjectProperties properties) {
		/*
		String name = properties.getName();
		if (Strings.isNullOrEmpty(name))
			throw new IllegalArgumentException("Must set name");

		//RequestBuilder builder = target.put(name, MediaType.APPLICATION_OCTET_STREAM_TYPE);

		if (properties.getContentType() != null) {
			MediaType contentType = MediaType.valueOf(properties.getContentType());
			builder.setContentType(contentType);
		}

		builder = SwiftHeaderUtils.setHeadersForProperties(builder, properties);

		builder.setMethod("PUT");
		return builder;
		*/
		return null;
	}

	public ObjectResource object(String name) {
		return new ObjectResource(target.path("/{name}").pathParam("name", name));
	}

}
