package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.model.Service;
import com.woorea.openstack.keystone.model.Services;

public class DomainGroupRolesResource extends GenericResource<Service, Services> {

	public DomainGroupRolesResource(OpenStackClient client, String path) {
		super(client, path, Service.class, Services.class);
	}

}
