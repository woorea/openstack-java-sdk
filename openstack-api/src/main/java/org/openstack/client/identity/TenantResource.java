package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneTenant;

public class TenantResource extends Resource {

	public KeyStoneTenant show() {
		return resource().get(KeyStoneTenant.class);
	}

//	public Tenant update() {
//		return resource().put(Tenant.class);
//	}

	public void delete() {
		 resource().delete();
	}

}
