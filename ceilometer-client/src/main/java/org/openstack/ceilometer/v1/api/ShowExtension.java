package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v1.model.Extension;

public class ShowExtension implements OpenStackCommand<Extension> {

	private String alias;
	
	public ShowExtension(String alias) {
		this.alias = alias;
	}

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		//return target.path("extensions").path(alias).request(MediaType.APPLICATION_JSON).get(Extension.class);
		return null;
	}

}
