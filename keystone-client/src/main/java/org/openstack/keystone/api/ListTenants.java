package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Tenants;

public class ListTenants extends OpenStackRequest {
	
	public ListTenants() {
		method(HttpMethod.GET);
		path("/tenants");
		header("Accept", "application/json");
		returnType(Tenants.class);
	}

}
