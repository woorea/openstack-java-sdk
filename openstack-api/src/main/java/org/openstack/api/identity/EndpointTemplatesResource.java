package org.openstack.api.identity;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneEndpointTemplates;
import org.openstack.model.identity.KeyStoneEndpointTemplatesList;

public class EndpointTemplatesResource extends Resource {
	
	public EndpointTemplatesResource() {
	}
	
	public EndpointTemplatesResource(Target target) {
		super(target);
	}
	
	public KeyStoneEndpointTemplatesList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", "secret0").get(KeyStoneEndpointTemplatesList.class);
	}

	public KeyStoneEndpointTemplates post(Entity<KeyStoneEndpointTemplates> user) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", "secret0").post(user, KeyStoneEndpointTemplates.class);
	}

	public EndpointTemplateResource endpointTemplate(String id) {
		return new EndpointTemplateResource(target.path("/{id}").pathParam("id", id));
	}

}
