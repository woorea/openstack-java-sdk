package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.openstack.model.compute.nova.keypair.NovaKeyPairList;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairsResource extends Resource {
	
	public KeyPairsResource(Target target) {
		super(target);
	}

	/**
	 * List of keypairs for a user
	 * 
	 * @return
	 */
	public KeyPairList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaKeyPairList.class);
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
	public KeyPair post(NovaKeyPair keyPair) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(keyPair, MediaType.APPLICATION_JSON), NovaKeyPair.class);
	}

	public KeyPairResource keypair(String name) {
		return new KeyPairResource(target.path("/{name}").pathParam("name", name));
	}

	

}
