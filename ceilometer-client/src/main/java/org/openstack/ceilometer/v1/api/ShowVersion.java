package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.v1.model.Version;

public class ShowVersion implements CeilometerCommand<Version> {

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		//return target.request(MediaType.APPLICATION_JSON).get(Version.class);
		return null;
	}

}
