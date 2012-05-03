package org.openstack.api.identity.admin.resources;
import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.keystone.KeystoneRoleList;

public class UserRolesResource extends Resource {
	
	public UserRolesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public RoleList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneRoleList.class);
	}
	
}
