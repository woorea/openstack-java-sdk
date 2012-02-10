package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.ServiceList;

import com.sun.jersey.api.client.Client;

public class ServicesRepresentation {
		
	private Client client;
	
	private ServiceList model;

	public ServicesRepresentation(Client client, ServiceList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<org.openstack.model.identity.Service> getList() {
		return model.getList();
	}
	
	public ServicesRepresentation next() {
		ServiceList tenantList = client.resource(model.getLinks().get(0).getHref()).get(ServiceList.class);
		return new ServicesRepresentation(client, tenantList);
	}
	
}
