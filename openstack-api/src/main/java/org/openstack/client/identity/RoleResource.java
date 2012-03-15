package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneRole;

public class RoleResource extends Resource {

	public KeyStoneRole show() {
		return resource().get(KeyStoneRole.class);
	}

//	public Role update() {
//		return JerseyClient.INSTANCE.get().resource(resource).accept(MediaType.APPLICATION_XML).put(Role.class);
//	}

	public void delete() {
		resource().delete();
	}

}
