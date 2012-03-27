package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.keystone.KeystoneEndpoint;

public class EndpointTemplateResource extends Resource {
	
	public EndpointTemplateResource(Target target) {
		super(target);
	}

	public Endpoint get() {
		return target.request().get(KeystoneEndpoint.class);
	}

	public Endpoint update(Entity<KeystoneEndpoint> entity) {
		return target.request().put(entity, KeystoneEndpoint.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
