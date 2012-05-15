package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

/**
 * Quotas management support
 * 
 * @author sp
 *
 */
public class QuotasResource extends Resource {

	public QuotasResource(Target target, Properties properties) {
		super(target, properties);
	}

	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public String update() {
		return null;
	}

}
