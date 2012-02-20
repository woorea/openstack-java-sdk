package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.Role;

public class RoleResource extends Resource {

	public Role show() {
		return resource().get(Role.class);
	}

//	public Role update() {
//		return JerseyClient.INSTANCE.get().resource(resource).accept(MediaType.APPLICATION_XML).put(Role.class);
//	}

	public void delete() {
		resource().delete();
	}

}
