package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.model.Service;
import com.woorea.openstack.keystone.model.Services;

public class GroupsResource extends GenericResource<Service, Services> {

	public GroupsResource(OpenStackClient client) {
		super(client, "/domains", Service.class, Services.class);
	}
	
	public DomainUserRolesResource userRoles(String domainId, String userId) {
		return new DomainUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(domainId).append("/users/").append(userId).append("/roles").toString());
	}

}
