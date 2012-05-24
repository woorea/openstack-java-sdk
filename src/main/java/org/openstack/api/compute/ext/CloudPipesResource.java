package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.cloudpipe.NovaCloudPipeForCreate;

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
public class CloudPipesResource extends Resource {

	public CloudPipesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public Response get() {
		return target.request(MediaType.APPLICATION_JSON).get();
	}
	
	/**
	 * Create a new cloudpipe instance, if none exists.
	 * 
	 * @param cloudpipeForCreate
	 * @return
	 */
	public Response post(NovaCloudPipeForCreate cloudpipeForCreate) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(cloudpipeForCreate, MediaType.APPLICATION_JSON));
	}


}
