package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;

import com.sun.jersey.api.client.Client;

public class TenantsResource extends Resource {
	
	public TenantsResource(Client client, String resource) {
		super(client, resource);
	}

	public TenantsRepresentation list() {
		TenantList tenantList = client.resource(resource).get(TenantList.class);
		return new TenantsRepresentation(client, tenantList);
	}
	
	public TenantResource create(Tenant tenant) {
		return null;
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
