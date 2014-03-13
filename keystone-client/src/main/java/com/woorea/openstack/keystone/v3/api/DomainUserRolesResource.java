package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.model.Role;
import com.woorea.openstack.keystone.model.Roles;

public class DomainUserRolesResource extends GenericResource<Role, Roles> {

	public DomainUserRolesResource(OpenStackClient client, String path) {
		super(client, path, Role.class, Roles.class);
	}

}
