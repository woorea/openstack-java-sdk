package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.keystone.KeyStoneTenant;

public class TenantsResource extends Resource {

	public Iterable<KeyStoneTenant> list() {
		TenantList list = resource().get(TenantList.class);
		return new SimplePagingList<KeyStoneTenant>(session, list);
	}

	// public TenantResource create(Tenant tenant) {
	// return null;
	// }

	public TenantResource tenant(String id) {
		return buildChildResource(id, TenantResource.class);
	}

}
