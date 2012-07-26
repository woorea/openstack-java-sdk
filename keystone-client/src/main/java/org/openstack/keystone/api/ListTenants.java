package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenants;

public class ListTenants implements KeystoneCommand<Tenants>{

	@Override
	public Tenants execute(WebTarget target) {
		return target.path("tenants").request(MediaType.APPLICATION_JSON).get(Tenants.class);
	}

}
