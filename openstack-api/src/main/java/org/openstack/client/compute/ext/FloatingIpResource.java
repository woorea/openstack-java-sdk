package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.FloatingIp;

/**
 * Keypair Support
 * 
 * @author sp
 *
 */
public class FloatingIpResource extends Resource {

	public FloatingIp show() {
		return resource().get(FloatingIp.class);	
	}
	
	public void delete() {
		 resource().delete();	
	}

}
