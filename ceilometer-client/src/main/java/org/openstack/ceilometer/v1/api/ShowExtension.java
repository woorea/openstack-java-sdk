package org.openstack.ceilometer.v1.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.v1.model.Extension;

public class ShowExtension implements CeilometerCommand<Extension> {

	private String alias;
	
	public ShowExtension(String alias) {
		this.alias = alias;
	}

	@Override
	public Extension execute(WebTarget target) {
		return target.path("extensions").path(alias).request(MediaType.APPLICATION_JSON).get(Extension.class);
	}

}
