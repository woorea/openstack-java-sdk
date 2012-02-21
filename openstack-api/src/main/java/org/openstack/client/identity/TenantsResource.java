package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;

public class TenantsResource extends Resource {

	public Iterable<Tenant> list() {
		TenantList list = resource().get(TenantList.class);
		return new SimplePagingList<Tenant>(session, list);
	}

	// public TenantResource create(Tenant tenant) {
	// return null;
	// }

	public TenantResource tenant(String id) {
		return buildChildResource(id, TenantResource.class);
	}

}
