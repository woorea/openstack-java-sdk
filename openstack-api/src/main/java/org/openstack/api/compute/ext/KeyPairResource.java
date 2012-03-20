package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairResource extends Resource {
	
	public KeyPairResource(Target target) {
		super(target);
	}


	public void delete(Map<String, Object> properties) {
		target.request().delete();
	}

	// OSAPI-BUG: This function is missing from the OS API
	// public KeyPair show() {
	// return resource().get(KeyPair.class);
	// }

}
