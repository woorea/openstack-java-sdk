package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Endpoints;

public class ListEndpoints extends OpenStackRequest {

	public ListEndpoints() {
		method(HttpMethod.GET);
		path("/endpoints");
		header("Accept", "application/json");
		returnType(Endpoints.class);
	}

}
