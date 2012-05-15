package org.openstack.api.compute.notavailable;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Adds actions to create cloudpipe instances.
 * 
 * When running with the Vlan network mode, you need a mechanism to route from
 * the public Internet to your vlans. This mechanism is known as a cloudpipe.
 * 
 * At the time of creating this class, only OpenVPN is supported. Support for a
 * SSH Bastion host is forthcoming.
 * 
 * @author sp
 * 
 */
public class CloudPipeResource extends Resource {

	public CloudPipeResource(Target target, Properties properties) {
		super(target, properties);
	}


}
