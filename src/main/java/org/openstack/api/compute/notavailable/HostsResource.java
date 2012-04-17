package org.openstack.api.compute.notavailable;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Admin-only host administration
 * 
 * @author sp
 *
 */
public class HostsResource extends Resource {

	protected HostsResource(Target target, Properties properties) {
		super(target, properties);
	}


}
