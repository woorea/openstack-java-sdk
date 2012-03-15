package org.openstack.client.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.imagestore.KnownLengthInputStream;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.storage.SwiftContainer;
import org.openstack.model.storage.SwiftObjectProperties;
import org.openstack.model.storage.SwiftStorageObject;
import org.openstack.utils.Io;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.sun.jersey.api.client.ClientResponse;

public class ObjectsResource extends StorageResourceBase {
	public Iterable<SwiftStorageObject> list() {
		return list(null, null);
	}

	public Iterable<SwiftStorageObject> list(String prefix, String delimiter) {
		RequestBuilder requestBuilder = resource();

		if (prefix != null) {
			requestBuilder.addQueryParameter("prefix", prefix);
		}
		if (!Strings.isNullOrEmpty(delimiter)) {
			requestBuilder.addQueryParameter("delimiter", delimiter);
		}

		requestBuilder.clearAcceptTypes();
		requestBuilder.addAcceptType(MediaType.TEXT_PLAIN_TYPE);

		String listing = requestBuilder.get(String.class);
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

		ClientResponse response = builder.put(ClientResponse.class, objectStream);
		MultivaluedMap<String, String> responseHeaders = response.getHeaders();

		SwiftObjectProperties responseProperties = new SwiftObjectProperties();
		String etag = responseHeaders.getFirst("ETag");

		if (etag != null) {
			responseProperties.setETag(etag);
		}
		return responseProperties;
	}

	public RequestBuilder buildPutRequest(SwiftObjectProperties properties) {
		String name = properties.getName();
		if (Strings.isNullOrEmpty(name))
			throw new IllegalArgumentException("Must set name");

		RequestBuilder builder = resource(name, MediaType.APPLICATION_OCTET_STREAM_TYPE);

		if (properties.getContentType() != null) {
			MediaType contentType = MediaType.valueOf(properties.getContentType());
			builder.setContentType(contentType);
		}

		builder = SwiftHeaderUtils.setHeadersForProperties(builder, properties);

		builder.setMethod("PUT");
		return builder;
	}

	public ObjectResource id(String objectName) {
		return buildChildResource(objectName, ObjectResource.class);
	}

}
