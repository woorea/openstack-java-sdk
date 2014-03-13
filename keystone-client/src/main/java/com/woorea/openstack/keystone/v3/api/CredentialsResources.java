package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.model.Endpoint;
import com.woorea.openstack.keystone.model.Endpoints;

public class CredentialsResources extends GenericResource<Endpoint, Endpoints> {

	public CredentialsResources(OpenStackClient client) {
		super(client, "/credentials", Endpoint.class, Endpoints.class);
	}

}
