package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Flavor;

import com.sun.jersey.api.client.Client;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumeTypesResource extends Resource {

	public VolumeTypesResource(Client client, String resource) {
		super(client, resource);
	}

	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public String list() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML)
				.get(String.class);
	}

	/**
	 * Creates a new volume type.
	 * 
	 * @param flavor
	 * @return
	 */
	public Flavor create(Flavor flavor) {
		return null;
	}

	public ZoneResource zone(String id) {
		return new ZoneResource(client, new StringBuilder(resource).append("/")
				.append(id).toString());
	}

}
