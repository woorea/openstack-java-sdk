package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;
import org.openstack.model.identity.keystone.KeystoneEndpoint;
import org.openstack.model.identity.keystone.KeystoneEndpointList;

public class EndpointsResource extends Resource {
	
	public EndpointsResource(Target target) {
		super(target);
	}
	
	public EndpointList get() {
		return target.request().get(KeystoneEndpointList.class);
	}

	public Endpoint post(Endpoint endpoint) {
		return target.request().post(Entity.entity(endpoint, MediaType.APPLICATION_JSON), KeystoneEndpoint.class);
	}

	public EndpointResource endpoint(String id) {
		return new EndpointResource(target.path("/{id}").pathParam("id", id));
	}

}
