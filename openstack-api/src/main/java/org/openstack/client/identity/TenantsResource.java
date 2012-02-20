package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.TenantList;

public class TenantsResource extends Resource {
	
	public TenantList list() {
		return resource().get(TenantList.class);
	}
	
//	public TenantResource create(Tenant tenant) {
//		return null;
//	}
	
	public TenantResource tenant(String id) {
		return buildChildResource(id, TenantResource.class);
	}
	
}
