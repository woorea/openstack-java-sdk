package org.openstack.client.identity;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.openstack.model.identity.KeyStoneTenantList;

public class TenantsRepresentation {
		
	private Client client;
	
	private KeyStoneTenantList model;

	public TenantsRepresentation(Client client, KeyStoneTenantList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<org.openstack.model.identity.KeyStoneTenant> getList() {
		return model.getList();
	}
	
	public TenantsRepresentation next() {
		KeyStoneTenantList tenantList = client.target(model.getLinks().get(0).getHref()).request(MediaType.APPLICATION_XML).get(KeyStoneTenantList.class);
		return new TenantsRepresentation(client, tenantList);
	}
	
}
