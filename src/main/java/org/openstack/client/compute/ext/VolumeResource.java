package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class VolumeResource extends Resource {

	public VolumeResource(Client client, String resource) {
		super(client, resource);
	}
	
	/**
	 * Return a single volume type item.
	 * 
	 * @return
	 */
	public String show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(String.class);
	}

	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}
	
}
