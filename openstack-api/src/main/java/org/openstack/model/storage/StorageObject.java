package org.openstack.model.storage;

import java.util.Date;

public interface StorageObject {

	String getName();

	String getHash();

	Long getBytes();

	String getContentType();

	Date getLastModified();

}