package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Instance rescue mode
 * 
 * @author sp
 *
 */
public class RescueResource extends Resource {

	public RescueResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	

}
