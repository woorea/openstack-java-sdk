package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Keypair Support
 * 
 * @author sp
 *
 */
public class KeyPairResource extends Resource {

	public KeyPairResource(Client client, String resource) {
		super(client, resource);
	}
	
	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();	
	}

}
