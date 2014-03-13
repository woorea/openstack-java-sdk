package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.model.Role;
import com.woorea.openstack.keystone.model.Roles;
import com.woorea.openstack.keystone.v3.model.Policies;
import com.woorea.openstack.keystone.v3.model.Policy;

public class PoliciesResource extends GenericResource<Policy, Policies> {

	public PoliciesResource(OpenStackClient client) {
		super(client, "/policies", Policy.class, Policies.class);
	}

}
