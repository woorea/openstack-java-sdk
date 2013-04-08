package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.v1.model.Sources;

public class SourceList implements CeilometerCommand<Sources> {

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		//return target.path("v1/sources").request(MediaType.APPLICATION_JSON).get(Sources.class);
		return null;
	}

}
