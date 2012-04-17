package org.openstack.api.compute.notavailable;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Floating IPs support
 * 
 * @author sp
 *
 */
public class FloatingIpPoolsResource extends Resource {

	protected FloatingIpPoolsResource(Target target, Properties properties) {
		super(target, properties);
	}


}
