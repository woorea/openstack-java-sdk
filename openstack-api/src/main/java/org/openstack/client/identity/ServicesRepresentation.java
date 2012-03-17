package org.openstack.client.identity;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.openstack.model.identity.KeyStoneServiceList;

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
		KeyStoneServiceList tenantList = client.target(model.getLinks().get(0).getHref()).request(MediaType.APPLICATION_XML).get(KeyStoneServiceList.class);
		return new ServicesRepresentation(client, tenantList);
	}
	
}
