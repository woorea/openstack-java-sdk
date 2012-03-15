package org.openstack.client.storage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.storage.SwiftObjectProperties;
import org.openstack.model.storage.SwiftStorageObject;
import org.openstack.utils.Io;

public class OpenstackStorageClient {

	final OpenStackSession session;
	AccountResource root;

	public OpenstackStorageClient(OpenStackSession session) {
		this.session = session;
		root();
	}

	public synchronized AccountResource root() {
		if (root == null) {
			String endpoint = session.getData().getBestEndpoint("object-store");

			root = new AccountResource(session, endpoint);
		}

		return root;
	}

	public OpenStackSession getSession() {
		return session;
	}
	
	public SwiftObjectProperties putObject(String containerName, String objectName, File file) throws OpenstackException, IOException {
		SwiftObjectProperties properties = new SwiftObjectProperties();
		properties.setName(objectName);
		return root().containers().id(containerName).objects().putObject(file, properties);
	}

	public SwiftObjectProperties putObject(String containerName, String objectName, InputStream objectData, long contentLength) throws OpenstackException, IOException {
		SwiftObjectProperties properties = new SwiftObjectProperties();
		properties.setName(objectName);
		return root().containers().id(containerName).objects().putObject(objectData, contentLength, properties);
	}
	
	public SwiftObjectProperties getObject(String containerName, String objectName, File destFile) throws IOException {
		ObjectResource objectResource = buildObjectResource(containerName, objectName);

		// TODO: It would be nicer to get this in one call
		SwiftObjectProperties metadata = objectResource.metadata();

		InputStream objectStream = objectResource.openStream();
		try {
			Io.copyStreams(objectStream, destFile);
		} finally {
			Io.safeClose(objectStream);
		}
		
		return metadata;
	}

	public void deleteObject(String containerName, String objectName) {
		ObjectResource objectResource = buildObjectResource(containerName, objectName);
		objectResource.delete();
	}

	public SwiftObjectProperties getObjectDetails(String containerName, String objectName) {
		ObjectResource objectResource = buildObjectResource(containerName, objectName);
		return objectResource.metadata();
	}

	public InputStream getDataInputStream(String containerName, String objectName) {
		ObjectResource objectResource = buildObjectResource(containerName, objectName);
		return objectResource.openStream();
	}

	private ObjectResource buildObjectResource(String containerName, String objectName) {
		ObjectResource objectResource = root().containers().id(containerName).objects().id(objectName);
		return objectResource;
	}

	public Iterable<SwiftStorageObject> listObjects(String containerName, String objectNamePrefix, String delimiter) {
		return root().containers().id(containerName).objects().list(objectNamePrefix, delimiter);
	}
}
