package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneRoleList;

public class RolesResource extends Resource {

	public KeyStoneRoleList list() {
		return resource().get(KeyStoneRoleList.class);
	}
	
//	public RoleResource create(Role tenant) {
//		return null;
//	}
	
	public RoleResource role(String id) {
		return buildChildResource(id, RoleResource.class);
	}
	
}
