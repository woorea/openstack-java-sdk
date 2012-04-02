package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumeTypesResource extends Resource {
	
	public VolumeTypesResource(Target target) {
		super(target);
	}

	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public String get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
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
