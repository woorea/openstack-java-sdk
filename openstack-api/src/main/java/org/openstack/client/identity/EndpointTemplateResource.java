package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.EndpointTemplate;

public class EndpointTemplateResource extends Resource {

	public EndpointTemplate show() {
		return resource().get(EndpointTemplate.class);
	}

	// public EndpointTemplate update() {
	// return resource().put(EndpointTemplate.class);
	// }

	public void delete() {
		resource().delete();
	}

}
