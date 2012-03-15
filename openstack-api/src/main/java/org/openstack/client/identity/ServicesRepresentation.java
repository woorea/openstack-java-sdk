package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.KeyStoneServiceList;

import com.sun.jersey.api.client.Client;

public class ServicesRepresentation {
		
	private Client client;
	
	private KeyStoneServiceList model;

	public ServicesRepresentation(Client client, KeyStoneServiceList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<org.openstack.model.identity.KeyStoneService> getList() {
		return model.getList();
	}
	
	public ServicesRepresentation next() {
		KeyStoneServiceList tenantList = client.resource(model.getLinks().get(0).getHref()).get(KeyStoneServiceList.class);
		return new ServicesRepresentation(client, tenantList);
	}
	
}
