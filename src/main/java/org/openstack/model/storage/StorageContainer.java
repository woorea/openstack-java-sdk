package org.openstack.model.storage;

import java.util.List;

public interface StorageContainer {

	String getName();

	long getCount();

	long getBytes();

	List<StorageObject> getObjects();

}