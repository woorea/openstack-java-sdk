package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneEndpointTemplates;

public class EndpointTemplateResource extends Resource {
	
	public EndpointTemplateResource(Target target) {
		super(target);
	}

	public KeystoneEndpointTemplates get() {
		return target.request().get(KeystoneEndpointTemplates.class);
	}

	public KeystoneEndpointTemplates update(Entity<KeystoneEndpointTemplates> entity) {
		return target.request().put(entity, KeystoneEndpointTemplates.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
