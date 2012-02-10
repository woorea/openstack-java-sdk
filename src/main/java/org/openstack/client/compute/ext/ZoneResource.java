package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.client.compute.FlavorResource;
import org.openstack.model.compute.Zone;

import com.sun.jersey.api.client.Client;

public class ZoneResource extends Resource {

	public ZoneResource(Client client, String resource) {
		super(client, resource);
	}
	
	/**
	 * Return name and capabilities for this zone.
	 * 
	 * @return
	 */
	public Zone info() {
		return  client.resource(resource).accept(MediaType.APPLICATION_XML).get(Zone.class);
	}

	public FlavorResource zone(String id) {
		return new FlavorResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
