package org.openstack.api.identity;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneEndpointTemplates;
import org.openstack.model.identity.KeystoneEndpointTemplatesList;

public class EndpointTemplatesResource extends Resource {
	
	public EndpointTemplatesResource(Target target) {
		super(target);
	}
	
	public KeystoneEndpointTemplatesList get(Map<String, Object> properties) {
		return target.request().get(KeystoneEndpointTemplatesList.class);
	}

	public KeystoneEndpointTemplates post(Entity<KeystoneEndpointTemplates> user) {
		return target.request().post(user, KeystoneEndpointTemplates.class);
	}

	public EndpointTemplateResource endpointTemplate(String id) {
		return new EndpointTemplateResource(target.path("/{id}").pathParam("id", id));
	}

	public KeystoneEndpointTemplatesList get() {
		return get(new HashMap<String, Object>());
	}

}
