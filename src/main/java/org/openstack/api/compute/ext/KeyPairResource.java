package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Keypair Support
 * 
 * @author sp
 * 
 */
public class KeyPairResource extends Resource {
	
	public KeyPairResource(Target target, Properties properties) {
		super(target, properties);
	}


	public void delete() {
		target.request().delete();
	}

	// OSAPI-BUG: This function is missing from the OS API
	// public KeyPair show() {
	// return resource().get(KeyPair.class);
	// }

}
