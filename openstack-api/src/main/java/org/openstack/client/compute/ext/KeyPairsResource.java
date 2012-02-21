package org.openstack.client.compute.ext;

import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.CreateKeyPairResponse;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairsResource extends Resource {

	// KeyPairsResource seems to be JSON only
	// TODO: Is this an OpenStack bug or an HP bug?
	@Override
	protected MediaType getDefaultContentType() {
		return MediaType.APPLICATION_JSON_TYPE;
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
		CreateKeyPairResponse response = resource().post(CreateKeyPairResponse.class, keyPair);
		return response.getKeyPair();
	}

	public KeyPairResource keypair(String name) {
		return buildChildResource(name, KeyPairResource.class);
	}

}
