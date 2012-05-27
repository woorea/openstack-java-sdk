package org.openstack.client;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.openstack.api.storage.AccountResource;
import org.openstack.api.storage.ContainerResource;
import org.openstack.model.storage.StorageContainer;
import org.openstack.model.storage.StorageObjectProperties;
import org.openstack.model.storage.swift.SwiftContainer;
import org.openstack.model.storage.swift.SwiftStorageObject;

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
	
	
	
	public void createDirectory(String containerName, String directoryName) {
		Response response = accountResource.container(containerName).object(directoryName).put();
	}
	
	public void createObject(String containerId, String objectId, InputStream is, int size, Map<String, String> properties) {
		Response response = accountResource.container(containerId).object(objectId).put(is,size, properties);
	}
	
	public void createObject(String containerId, String objectId, File file, Map<String,String> properties) {
		Response response = accountResource.container(containerId).object(objectId).put(file, properties);
	}
	
	public void createObject(String containerId, String objectId, File file) {
		Response response = accountResource.container(containerId).object(objectId).put(file, null);
	}
	
	public StorageObjectProperties showObject(String containerId, String objectId) {
		return accountResource.container(containerId).object(objectId).head();
	}
	
	public InputStream getObjectAsInputStream(String containerId, String objectId) {
		return accountResource.container(containerId).object(objectId).get(InputStream.class);
	}
	
	public String getObjectAsString(String containerId, String objectId) {
		return accountResource.container(containerId).object(objectId).get(String.class);
	}
	
	public byte[] getObjectAsByteArray(String containerId, String objectId) {
		return accountResource.container(containerId).object(objectId).get(byte[].class);
	}
	
	public void deleteObject(String containerId, String objectId) {
		Response response = accountResource.container(containerId).object(objectId).delete();
	}
	
	
}
