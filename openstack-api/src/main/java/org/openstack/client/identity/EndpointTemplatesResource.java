package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;

public class EndpointTemplatesResource extends Resource {

	public KeyStoneEndpointTemplatesList list() {
		return resource().get(KeyStoneEndpointTemplatesList.class);
	}

	// public EndpointTemplateResource create(EndpointTemplate tenant) {
	// return null;
	// }

	public EndpointTemplateResource endpointTemplate(String id) {
		return buildChildResource(id, EndpointTemplateResource.class);
	}

}
