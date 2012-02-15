package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.FloatingIp;

import com.sun.jersey.api.client.Client;

/**
 * Keypair Support
 * 
 * @author sp
 *
 */
public class FloatingIpResource extends Resource {

	public FloatingIpResource(Client client, String resource) {
		super(client, resource);
	}
	
	public FloatingIp show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(FloatingIp.class);	
	}
	
	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();	
	}

}
