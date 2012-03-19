//package org.openstack.api.storage;
//
//import org.openstack.client.RequestBuilder;
//import org.openstack.model.storage.SwiftAccount;
//import org.openstack.model.storage.SwiftContainer;
//
//public class ContainersResource extends StorageResourceBase {
//
//	// GET /account List containers
//	// HEAD account Retrieve account metadata
//
//	// Verb URI Description
//	// GET /account/container List objects
//	// PUT /account/container Create container
//	// DELETE /account/container Delete container
//	// HEAD /account/container Retrieve container metadata
//
//	// Storage Objects
//	// Verb URI Description
//	// GET /account/container/object Retrieve object
//	// PUT /account/container/object Create/Update Object
//	// PUT /account/container/object Chunked transfer encoding
//	// DELETE /account/container/object Delete container
//	// HEAD /account/container/object Retrieve object metadata
//	// POST /account/container/object Update object metadata
//
//	public Iterable<SwiftContainer> list() {
//		RequestBuilder imagesResource = resource();
//
//		SwiftAccount account = imagesResource.get(SwiftAccount.class);
//		return account.getContainers();
//	}
//
//	public ContainerResource id(String id) {
//		return (id, ContainerResource.class);
//	}
//	
//	public void post(String containerName) {
//		// Should return 202
//		resource(containerName).put();
//	}
//
//}
