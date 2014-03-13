package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.v3.model.Endpoint;
import com.woorea.openstack.keystone.v3.model.Endpoints;

public class EndpointsResource extends GenericResource<Endpoint, Endpoints> {

	public EndpointsResource(OpenStackClient client) {
		super(client, "/endpoints", Endpoint.class, Endpoints.class);
	}

}
