package org.openstack.api.storage;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.storage.SwiftContainer;

public class ContainersResource extends Resource {

	

	protected ContainersResource(Target target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public ContainerResource id(String id) {
		return new ContainerResource(target.path("/{id}").pathParam("id", id));
	}
	
	public void post(String containerName) {
		// Should return 202
//		resource(containerName).put();
	}

}
