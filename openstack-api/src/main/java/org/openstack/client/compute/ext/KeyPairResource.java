package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.WebResource.Builder;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairResource extends Resource {

	// JSON Only?
	// TODO: Is this an OpenStack bug or an HP bug?
	protected Builder addAcceptHeaders(Builder webResource) {
		return webResource.accept(MediaType.APPLICATION_JSON);
	}

	public void delete() {
		resource().delete();
	}

}
