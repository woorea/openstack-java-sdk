package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v1.model.Sources;

public class SourceList implements OpenStackCommand<Sources> {

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		//return target.path("v1/sources").request(MediaType.APPLICATION_JSON).get(Sources.class);
		return null;
	}

}
