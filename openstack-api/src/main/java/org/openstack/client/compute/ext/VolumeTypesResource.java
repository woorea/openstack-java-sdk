package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumeTypesResource extends Resource {

	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public String list() {
		return  resource().get(String.class);
	}

	/**
	 * Creates a new volume type.
	 * 
	 * @param flavor
	 * @return
	 */
//	public Flavor create(Flavor flavor) {
//		return null;
//	}

	public ZoneResource zone(String id) {
		return buildChildResource(id, ZoneResource.class);
	}

}
