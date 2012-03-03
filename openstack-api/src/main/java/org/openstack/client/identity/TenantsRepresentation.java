package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;

import com.sun.jersey.api.client.Client;

public class TenantsRepresentation {
		
	private Client client;
	
	private TenantList model;

	public TenantsRepresentation(Client client, TenantList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<Tenant> getList() {
		return model.getList();
	}
	
	public TenantsRepresentation next() {
		TenantList tenantList = client.resource(model.getLinks().get(0).getHref()).get(TenantList.class);
		return new TenantsRepresentation(client, tenantList);
	}
	
}
