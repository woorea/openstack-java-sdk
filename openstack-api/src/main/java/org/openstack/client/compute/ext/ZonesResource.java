package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Zone;
import org.openstack.model.compute.ZoneList;

/**
 * Enables zones-related functionality such as adding child zones, listing child
 * zones, getting the capabilities of the local zone, and returning build plans
 * to parent zones' schedulers
 * 
 * @author sp
 * 
 */
public class ZonesResource extends Resource {

	/**
	 * Return all zones in brief
	 * 
	 * @return
	 */
	public ZoneList list() {
		return resource().get(ZoneList.class);
	}

	/**
	 * Return all zones in detail
	 * 
	 * @return
	 */
	public ZoneList detail() {
		return resource("detail").get(ZoneList.class);
	}

	public Zone create(Zone zone) {
		return resource().post(Zone.class, zone);
	}

	public ZoneResource zone(String id) {
		return buildChildResource(id, ZoneResource.class);
	}

}
