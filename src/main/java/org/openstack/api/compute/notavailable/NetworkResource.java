package org.openstack.api.compute.notavailable;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Admin-only Network Management Extension
 * 
 * @author sp
 *
 */
public class NetworkResource extends Resource {

	protected NetworkResource(Target target, Properties properties) {
		super(target, properties);
	}


}
