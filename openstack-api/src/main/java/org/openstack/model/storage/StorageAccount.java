package org.openstack.model.storage;

import java.util.List;

import org.openstack.model.storage.swift.SwiftContainer;

public interface StorageAccount {

	List<StorageContainer> getContainers();

}