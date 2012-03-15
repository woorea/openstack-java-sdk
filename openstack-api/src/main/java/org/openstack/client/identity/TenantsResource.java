package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;

public class TenantsResource extends Resource {

	public Iterable<KeyStoneTenant> list() {
		KeyStoneTenantList list = resource().get(KeyStoneTenantList.class);
		return new SimplePagingList<KeyStoneTenant>(session, list);
	}

	// public TenantResource create(Tenant tenant) {
	// return null;
	// }

	public TenantResource tenant(String id) {
		return buildChildResource(id, TenantResource.class);
	}

}
