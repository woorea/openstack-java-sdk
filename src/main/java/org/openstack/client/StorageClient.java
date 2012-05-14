package org.openstack.client;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Response;

import org.openstack.api.storage.AccountResource;
import org.openstack.api.storage.ContainerResource;
import org.openstack.model.storage.StorageContainer;
import org.openstack.model.storage.StorageObjectProperties;
import org.openstack.model.storage.swift.SwiftContainer;
import org.openstack.model.storage.swift.SwiftStorageObject;
import org.openstack.model.storage.swift.SwiftStorageObjectProperties;

public class StorageClient {

	private AccountResource accountResource;
	
	public StorageClient(AccountResource accountResource) {
		this.accountResource = accountResource;
	}
	
	public List<StorageContainer> listContainers() {
		return accountResource.get();
	}
	
	public void createContainer(String id) {
		accountResource.container(id).put();
	}
	
	public StorageContainer showContainer(String name) {
		Response response = accountResource.container(name).head();
		System.out.println(response);
		return new SwiftContainer();
	}
	
	
	public void deleteContainer(String id) {
		accountResource.container(id).delete();
	}
	
	public List<SwiftStorageObject> listObjects(String containerName, String prefix) {
		ContainerResource container = accountResource.container(containerName);
		return container.get(prefix,"/");
	}
	
	
	
	public void createDirectory(String containerName, String objectName, String directoryName) {
		Response response = accountResource.container(containerName).object(objectName + directoryName).put();
	}
	
	public void createObject(String containerId, String objectId, InputStream is, int size, SwiftStorageObjectProperties properties) {
		Response response = accountResource.container(containerId).object(objectId).put(is,size, properties);
	}
	
	public StorageObjectProperties showObject(String containerId, String objectId) {
		return accountResource.container(containerId).object(objectId).head();
	}
	
	public InputStream getObjectInputStream(String containerId, String objectId) {
		return accountResource.container(containerId).object(objectId).openStream();
	}
	
	public void deleteObject(String containerId, String objectId) {
		Response response = accountResource.container(containerId).object(objectId).delete();
	}
	
	
}
