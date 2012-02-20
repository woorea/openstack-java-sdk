package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairsResource extends Resource {

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
