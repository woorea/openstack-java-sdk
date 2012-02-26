package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.client.common.ResourceExtension;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairResource extends Resource implements ResourceExtension {

	// JSON Only?
	// TODO: Is this an OpenStack bug or an HP bug?
	@Override
	protected MediaType getDefaultContentType() {
		return MediaType.APPLICATION_JSON_TYPE;
	}


	public void delete() {
		resource().delete();
	}

	// OSAPI-BUG: This function is missing from the OS API
	// public KeyPair show() {
	// return resource().get(KeyPair.class);
	// }

}
