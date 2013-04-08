package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.v1.model.Extension;

public class ShowExtension implements CeilometerCommand<Extension> {

	private String alias;
	
	public ShowExtension(String alias) {
		this.alias = alias;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		//return target.path("extensions").path(alias).request(MediaType.APPLICATION_JSON).get(Extension.class);
		return null;
	}

}
