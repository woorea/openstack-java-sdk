package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v1.model.Version;

public class ShowVersion implements OpenStackCommand<Version> {

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		//return target.request(MediaType.APPLICATION_JSON).get(Version.class);
		return null;
	}

}
