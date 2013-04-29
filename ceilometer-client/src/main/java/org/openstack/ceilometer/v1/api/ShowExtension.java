package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public class ShowExtension extends OpenStackRequest {

	private String alias;
	
	public ShowExtension(String alias) {
		this.alias = alias;
	}

	public ShowExtension(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		//return target.path("extensions").path(alias).request(MediaType.APPLICATION_JSON).get(Extension.class);
	}

}
