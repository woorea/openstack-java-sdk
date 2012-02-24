package org.openstack.client.storage;


public class ContainerResource extends StorageResourceBase {
	public void delete() {
		resource().delete();
	}

	public ObjectsResource objects() {
		return buildChildResource("", ObjectsResource.class);
	}

}
