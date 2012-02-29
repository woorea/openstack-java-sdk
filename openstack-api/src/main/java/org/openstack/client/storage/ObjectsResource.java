package org.openstack.client.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.RequestBuilder;
import org.openstack.client.imagestore.KnownLengthInputStream;
import org.openstack.model.storage.Container;
import org.openstack.model.storage.ObjectProperties;
import org.openstack.model.storage.StorageObject;
import org.openstack.utils.Io;

import com.google.common.base.Strings;

public class ObjectsResource extends StorageResourceBase {
	public Iterable<StorageObject> list() {
		Container account = resource().get(Container.class);
		return account.getObjects();
	}

	public void addObject(File imageFile, ObjectProperties properties) throws IOException, OpenstackException {
		FileInputStream fis = new FileInputStream(imageFile);
		try {
			putObject(fis, imageFile.length(), properties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public void putObject(InputStream imageStream, long imageStreamLength, ObjectProperties properties)
			throws OpenstackException, IOException {

		if (imageStreamLength != -1) {
			imageStream = new KnownLengthInputStream(imageStream, imageStreamLength);
		}

		RequestBuilder builder = buildPutRequest(properties);

		builder.put(imageStream);
	}

	public RequestBuilder buildPutRequest(ObjectProperties properties) {
		String name = properties.getName();
		if (Strings.isNullOrEmpty(name))
			throw new IllegalArgumentException("Must set name");

		RequestBuilder builder = resource(name, MediaType.APPLICATION_OCTET_STREAM_TYPE);

		builder = SwiftHeaderUtils.setHeadersForProperties(builder, properties);

		builder.setMethod("PUT");
		return builder;
	}

	public ObjectResource id(String objectName) {
		return buildChildResource(objectName, ObjectResource.class);
	}
}
