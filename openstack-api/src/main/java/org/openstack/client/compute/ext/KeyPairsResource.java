package org.openstack.client.compute.ext;

import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.NovaCreateKeyPairResponse;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.compute.NovaKeyPairList;

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
	public NovaKeyPairList list() {
		return resource().get(NovaKeyPairList.class);
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
	public NovaKeyPair create(NovaKeyPair keyPair) {
		NovaCreateKeyPairResponse response = resource().post(NovaCreateKeyPairResponse.class, keyPair);
		return response.getKeyPair();
	}

	public KeyPairResource keypair(String name) {
		return buildChildResource(name, KeyPairResource.class);
	}

}
