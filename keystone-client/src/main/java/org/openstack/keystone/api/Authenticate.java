package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;

public class Authenticate extends OpenStackRequest<Access> {
	
	private Authentication authentication;
	
	public Authenticate(Authentication authentication) {
		method(HttpMethod.POST);
		path("/tokens");
		json(authentication);
		header("Accept", "application/json");
		returnType(Access.class);
	}
	
	public Authenticate withTenantId(String tenantId) {
		authentication.setTenantId(tenantId);
		return this;
	}
	
	public Authenticate withTenantName(String tenantName) {
		authentication.setTenantName(tenantName);
		return this;
	}
	
}
