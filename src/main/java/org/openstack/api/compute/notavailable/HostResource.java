package org.openstack.api.compute.notavailable;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Admin-only host administration
 * 
 * @author sp
 *
 */
public class HostResource extends Resource {

	protected HostResource(Target target) {
		super(target);
	}


}
