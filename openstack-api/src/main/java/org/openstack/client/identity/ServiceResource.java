package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneService;

public class ServiceResource extends Resource {

	public KeyStoneService show() {
		return resource().get(KeyStoneService.class);
	}

	// ??
	// public Service update() {
	// return resource().put(Service.class);
	// }

	public void delete() {
		resource().delete();
	}

}
