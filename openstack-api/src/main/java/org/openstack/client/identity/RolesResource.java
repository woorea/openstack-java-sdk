package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.RoleList;

public class RolesResource extends Resource {

	public RoleList list() {
		return resource().get(RoleList.class);
	}
	
//	public RoleResource create(Role tenant) {
//		return null;
//	}
	
	public RoleResource role(String id) {
		return buildChildResource(id, RoleResource.class);
	}
	
}
