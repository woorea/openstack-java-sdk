package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;

import com.sun.jersey.api.client.Client;

public class RolesResource extends Resource {
	
	public RolesResource(Client client, String resource) {
		super(client, resource);
	}

	public RolesRepresentation list() {
		RoleList tenantList = client.resource(resource).get(RoleList.class);
		return new RolesRepresentation(client, tenantList);
	}
	
	public RoleResource create(Role tenant) {
		return null;
	}
	
	public RoleResource role(String id) {
		return new RoleResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
