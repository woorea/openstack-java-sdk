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
 * 
 *  Creating a Cloudpipe Image
 *  
 *  To make a cloudpipe image:
 *  
 *  install openvpn on a base ubuntu image.
 *  
 *  set up a server.conf.template in /etc/openvpn/

    set up.sh in /etc/openvpn/

    set down.sh in /etc/openvpn/

    download and run the payload on boot from /etc/rc.local

    setup /etc/network/interfaces

    upload the image and set the image id in your config file:

    vpn_image_id=[uuid from glance]
                            

    you should set a few other configuration options to make VPNs work properly:

    use_project_ca=True
    cnt_vpn_clients=5
    force_dhcp_release=True

    creates a keypair called <project_id>-vpn and saves it in the keys directory

    creates a security group <project_id>-vpn and opens up 1194 and icmp

    creates a cert and private key for the VPN instance and saves it in the CA/projects/<project_id>/ directory

    zips up the info and puts it b64 encoded as user data

    launches an [vpn_instance_type] instance with the above settings using the option-specified VPN image
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
