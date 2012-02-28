package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.keystone.KeyStoneTenant;

public class TenantResource extends Resource {

	public Tenant show() {
		return resource().get(KeyStoneTenant.class);
	}

//	public Tenant update() {
//		return resource().put(Tenant.class);
//	}

	public void delete() {
		 resource().delete();
	}

}
