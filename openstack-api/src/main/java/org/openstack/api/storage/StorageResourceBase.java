package org.openstack.api.storage;

import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

abstract class StorageResourceBase extends Resource {
	public StorageResourceBase() {
	}

	@Override
	protected MediaType getDefaultContentType() {
		return MediaType.APPLICATION_XML_TYPE;
	}
}
