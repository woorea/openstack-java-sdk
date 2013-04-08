package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.v1.model.Extensions;

public class ExtensionList implements CeilometerCommand<Extensions> {

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		//return target.path("extensions").request(MediaType.APPLICATION_JSON).get(Extensions.class);
		return null;
	}

}
