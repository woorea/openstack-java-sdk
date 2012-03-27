package org.openstack.api.identity.admin.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.model.identity.keystone.KeystoneEndpointList;

public class EndpointTemplatesResource extends Resource {
	
	public EndpointTemplatesResource(Target target) {
		super(target);
	}
	
	public EndpointList get(Map<String, Object> properties) {
		return target.request().get(KeystoneEndpointList.class);
	}

	public Endpoint post(Entity<Endpoint> user) {
		return target.request().post(user, KeystoneEndpoint.class);
	}

	public EndpointTemplateResource endpointTemplate(String id) {
		return new EndpointTemplateResource(target.path("/{id}").pathParam("id", id));
	}

	public EndpointList get() {
		return get(new HashMap<String, Object>());
	}

}
