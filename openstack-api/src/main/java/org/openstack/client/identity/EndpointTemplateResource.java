package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneEndpointTemplates;

public class EndpointTemplateResource extends Resource {

	public KeyStoneEndpointTemplates show() {
		return resource().get(KeyStoneEndpointTemplates.class);
	}

	// public EndpointTemplate update() {
	// return resource().put(EndpointTemplate.class);
	// }

	public void delete() {
		resource().delete();
	}

}
