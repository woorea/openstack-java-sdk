package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.KeyStoneTenantList;

import com.sun.jersey.api.client.Client;

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
		KeyStoneTenantList tenantList = client.resource(model.getLinks().get(0).getHref()).get(KeyStoneTenantList.class);
		return new TenantsRepresentation(client, tenantList);
	}
	
}
