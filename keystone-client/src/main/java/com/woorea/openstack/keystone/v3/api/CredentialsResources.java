package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.v3.model.Credential;
import com.woorea.openstack.keystone.v3.model.Credentials;

public class CredentialsResources extends GenericResource<Credential, Credentials> {

	public CredentialsResources(OpenStackClient client) {
		super(client, "/credentials", Credential.class, Credentials.class);
	}

}
