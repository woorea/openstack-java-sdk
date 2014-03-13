package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.model.Role;
import com.woorea.openstack.keystone.model.Roles;

public class PoliciesResource extends GenericResource<Role, Roles> {

	public PoliciesResource(OpenStackClient client) {
		super(client, "/policies", Role.class, Roles.class);
	}

}
