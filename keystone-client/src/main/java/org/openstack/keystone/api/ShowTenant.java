package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenant;

public class ShowTenant implements KeystoneCommand<Tenant>{
	
	private String id;
	
	public ShowTenant(String id) {
		this.id = id;
	}

	@Override
	public Tenant execute(WebTarget target) {
		return target.path("tenants").path(id).request(MediaType.APPLICATION_JSON).get(Tenant.class);
	}

}
