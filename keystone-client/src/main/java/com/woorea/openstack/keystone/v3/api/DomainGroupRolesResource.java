package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.v3.model.Role;
import com.woorea.openstack.keystone.v3.model.Roles;

public class DomainGroupRolesResource extends GenericResource<Role, Roles> {

	public DomainGroupRolesResource(OpenStackClient client, String path) {
		super(client, path, Role.class, Roles.class);
	}

}
