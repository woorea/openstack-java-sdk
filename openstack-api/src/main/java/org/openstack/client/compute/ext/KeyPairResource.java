package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

/**
 * Keypair Support
 * 
 * @author sp
 *
 */
public class KeyPairResource extends Resource {

	public void delete() {
		 resource().delete();	
	}

}
