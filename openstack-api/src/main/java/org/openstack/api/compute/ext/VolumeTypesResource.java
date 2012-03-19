package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

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
	public String get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(String.class);
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


}
