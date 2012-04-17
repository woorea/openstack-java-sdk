package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Quotas management support
 * 
 * @author sp
 *
 */
public class QuotasResource extends Resource {

	protected QuotasResource(Target target, Properties properties) {
		super(target, properties);
	}

	public String show() {
		return null;
	}
	
	public String update() {
		return null;
	}

}
