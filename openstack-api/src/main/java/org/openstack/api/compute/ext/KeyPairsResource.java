package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
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
	
	public KeyPairsResource(Target target) {
		super(target);
	}

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
	public NovaKeyPairList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(NovaKeyPairList.class);
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
