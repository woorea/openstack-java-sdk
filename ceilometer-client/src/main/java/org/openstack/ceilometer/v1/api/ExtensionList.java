package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v1.model.Extensions;

public class ExtensionList implements OpenStackCommand<Extensions> {

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		//return target.path("extensions").request(MediaType.APPLICATION_JSON).get(Extensions.class);
		return null;
	}

}
