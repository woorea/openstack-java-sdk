package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.keystone.KeystoneEndpoint;

public class EndpointResource extends Resource {
	
	public EndpointResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public Endpoint get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneEndpoint.class);
	}

	public Endpoint update(Entity<KeystoneEndpoint> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneEndpoint.class);
	}
	
	public Response delete() {
		return target.request(MediaType.APPLICATION_JSON).delete();
	}

}
