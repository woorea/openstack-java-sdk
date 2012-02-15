package org.openstack.client.compute.ext;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairList;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairsResource extends Resource {

	public KeyPairsResource(Client client, String resource) {
		super(client, resource);
	}
	
	/**
	 * List of keypairs for a user
	 * 
	 * @return
	 */
	public KeyPairList list() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(KeyPairList.class);
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
		return client.resource(resource).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).post(KeyPair.class, keyPair);
	}
	
	public KeyPairResource keypair(String name) {
		return new KeyPairResource(client, new StringBuilder(resource).append("/").append(name).toString());
	}

}
