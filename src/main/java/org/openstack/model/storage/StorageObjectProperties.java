package org.openstack.model.storage;

import java.util.Date;
import java.util.Map;

public interface StorageObjectProperties {

	String getName();

	Map<String, String> getCustomProperties();

	Date getDate();

	Date getLastModified();

	Long getContentLength();

	String getETag();

	String getContentType();

	Date getLastModifiedDate();

}