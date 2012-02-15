package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Zone;
import org.openstack.model.compute.ZoneList;

import com.sun.jersey.api.client.Client;

/**
 * Enables zones-related functionality such as adding child zones, listing child
 * zones, getting the capabilities of the local zone, and returning build plans
 * to parent zones' schedulers
 * 
 * @author sp
 * 
 */
public class ZonesResource extends Resource {

	public ZonesResource(Client client, String resource) {
		super(client, resource);
	}

	/**
	 * Return all zones in brief
	 * 
	 * @return
	 */
	public ZoneList list() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(ZoneList.class);
	}

	/**
	 * Return all zones in detail
	 * 
	 * @return
	 */
	public ZoneList detail() {
		return client.resource(new StringBuilder(resource).append("/detail").toString()).accept(MediaType.APPLICATION_XML).get(ZoneList.class);
	}

	public Zone create(Zone zone) {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).post(Zone.class, zone);
	}

	public ZoneResource zone(String id) {
		return new ZoneResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}

}
