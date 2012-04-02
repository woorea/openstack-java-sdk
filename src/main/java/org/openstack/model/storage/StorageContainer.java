package org.openstack.model.storage;

import java.util.List;

import org.openstack.model.storage.swift.SwiftStorageObject;

public interface StorageContainer {

	String getName();

	long getCount();

	long getBytes();

	List<StorageObject> getObjects();

}