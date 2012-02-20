package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.EndpointTemplateList;

public class EndpointTemplatesResource extends Resource {

	public EndpointTemplateList list() {
		return resource().get(EndpointTemplateList.class);
	}

	// public EndpointTemplateResource create(EndpointTemplate tenant) {
	// return null;
	// }

	public EndpointTemplateResource endpointTemplate(String id) {
		return buildChildResource(id, EndpointTemplateResource.class);
	}

}
