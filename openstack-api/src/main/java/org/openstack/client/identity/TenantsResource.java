package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneTenantList;

public class TenantsResource extends Resource {

	public KeyStoneTenantList list() {
		return resource().get(KeyStoneTenantList.class);
	}

	// public TenantResource create(Tenant tenant) {
	// return null;
	// }

	public TenantResource tenant(String id) {
		return buildChildResource(id, TenantResource.class);
	}

}
