package org.openstack.api.compute.notavailable;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Admin-only Network Management Extension
 * 
 * @author sp
 *
 */
public class NetworkResource extends Resource {

	protected NetworkResource(Target target) {
		super(target);
	}


}
