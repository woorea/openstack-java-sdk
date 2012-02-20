package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;

import com.sun.jersey.api.client.WebResource.Builder;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairsResource extends Resource {

	// KeyPairsResource seems to be JSON only
	// TODO: Is this an OpenStack bug or an HP bug?
	protected Builder addAcceptHeaders(Builder webResource) {
		return webResource.accept(MediaType.APPLICATION_JSON);
	}

	/**
	 * List of keypairs for a user
	 * 
	 * @return
	 */
	public KeyPairList list() {
		return resource().get(KeyPairList.class);
	}
	/**
	 * Create or import keypair.
	 * 
	 * Sending name will generate a key and return private key and fingerprint.
	 * 
	 * You can send a public key to add an existing ssh key
	 * 
	 * @param keyPair
	 * @return
	 */
	public KeyPair create(KeyPair keyPair) {
		return resource().type(MediaType.APPLICATION_XML).post(KeyPair.class, keyPair);
	}
	
	public KeyPairResource keypair(String name) {
		return buildChildResource(name, KeyPairResource.class);
	}

}
