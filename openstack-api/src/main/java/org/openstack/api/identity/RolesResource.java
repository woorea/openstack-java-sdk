package org.openstack.api.identity;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneEndpointTemplates;
import org.openstack.model.identity.KeyStoneRole;
import org.openstack.model.identity.KeyStoneRoleList;

public class RolesResource extends Resource {
	
	public RolesResource(Target target) {
		super(target);
	}
	
	public KeyStoneRoleList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(KeyStoneRoleList.class);
	}
	
	public KeyStoneRole post(Entity<KeyStoneRole> user) {
		return target.request(MediaType.APPLICATION_JSON).post(user, KeyStoneRole.class);
	}
	
	public RoleResource role(String id) {
		return new RoleResource(target.path("/{id}").pathParam("id", id));
	}
	
}
