package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.EndpointTemplate;
import org.openstack.model.identity.EndpointTemplateList;

import com.sun.jersey.api.client.Client;

public class EndpointTemplatesResource extends Resource {
	
	public EndpointTemplatesResource(Client client, String resource) {
		super(client, resource);
	}

	public EndpointTemplatesRepresentation list() {
		EndpointTemplateList tenantList = client.resource(resource).get(EndpointTemplateList.class);
		return new EndpointTemplatesRepresentation(client, tenantList);
	}
	
	public EndpointTemplateResource create(EndpointTemplate tenant) {
		return null;
	}
	
	public EndpointTemplateResource endpointTemplate(String id) {
		return new EndpointTemplateResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
