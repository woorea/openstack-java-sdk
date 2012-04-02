package org.openstack.api.compute.ext;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Quotas management support
 * 
 * @author sp
 *
 */
public class QuotasResource extends Resource {

	protected QuotasResource(Target target) {
		super(target);
	}

	public String show() {
		return null;
	}
	
	public String update() {
		return null;
	}

}
