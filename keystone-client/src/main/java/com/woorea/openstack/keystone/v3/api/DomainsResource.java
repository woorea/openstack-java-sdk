package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.v3.model.Domain;
import com.woorea.openstack.keystone.v3.model.Domains;

public class DomainsResource extends GenericResource<Domain, Domains> {

	public DomainsResource(OpenStackClient client) {
		super(client, "/domains", Domain.class, Domains.class);
	}
	
	public DomainUserRolesResource userRoles(String domainId, String userId) {
		return new DomainUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(domainId).append("/users/").append(userId).append("/roles").toString());
	}
	
	public DomainUserRolesResource groupRoles(String domainId, String groupId) {
		return new DomainUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(domainId).append("/groups/").append(groupId).append("/roles").toString());
	}

}
