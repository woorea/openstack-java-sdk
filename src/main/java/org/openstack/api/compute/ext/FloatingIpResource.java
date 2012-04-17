package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.nova.floatingip.NovaFloatingIp;

/**
 * FloatingIpResource Support
 * 
 * @author sp
 *
 */
public class FloatingIpResource extends Resource {

	public FloatingIpResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public FloatingIp get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaFloatingIp.class);
	}
	
	public void delete() {
		 target.request().delete();	
	}

}
