package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneEndpointTemplates;
import org.openstack.model.identity.KeyStoneUser;

public class EndpointTemplateResource extends Resource {
	
	public EndpointTemplateResource() {
	}
	
	public EndpointTemplateResource(Target target) {
		super(target);
	}

	public KeyStoneEndpointTemplates get() {
		return target.request(MediaType.APPLICATION_XML).get(KeyStoneEndpointTemplates.class);
	}

	public KeyStoneEndpointTemplates update(Entity<KeyStoneEndpointTemplates> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeyStoneEndpointTemplates.class);
	}
	
	public void delete() {
		target.request().delete();
	}

}
