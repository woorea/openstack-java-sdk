package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.EndpointTemplate;
import org.openstack.model.identity.EndpointTemplateList;

import com.sun.jersey.api.client.Client;

public class EndpointTemplatesRepresentation {
		
	private Client client;
	
	private EndpointTemplateList model;

	public EndpointTemplatesRepresentation(Client client, EndpointTemplateList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<EndpointTemplate> getList() {
		return model.getList();
	}
	
	public EndpointTemplatesRepresentation next() {
		EndpointTemplateList tenantList = client.resource(model.getLinks().get(0).getHref()).get(EndpointTemplateList.class);
		return new EndpointTemplatesRepresentation(client, tenantList);
	}
	
}
