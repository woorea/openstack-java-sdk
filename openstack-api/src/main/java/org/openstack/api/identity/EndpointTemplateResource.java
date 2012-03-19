package org.openstack.api.identity;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneEndpointTemplates;

public class EndpointTemplateResource extends Resource {
	
	public EndpointTemplateResource() {
	}
	
	public EndpointTemplateResource(Target target) {
		super(target);
	}

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
