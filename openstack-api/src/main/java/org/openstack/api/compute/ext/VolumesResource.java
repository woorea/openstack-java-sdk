package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.api.compute.ImageResource;
import org.openstack.model.compute.NovaVolumeList;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumesResource extends Resource {
	
	public VolumesResource(Target target) {
		super(target);
	}
	
	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public NovaVolumeList get(Map<String, Object> properties) {
		if(properties.get("detail") != null) {
			target =  target.path("/detail");
		} 
		return target.request(MediaType.APPLICATION_JSON).get(NovaVolumeList.class);
	}

	/**
	 * Creates a new volume type.
	 * 
	 * @param flavor
	 * @return
	 */
	//	public Volume create(Volume volume) {
	//		return null;
	//	}

	public VolumeResource volume(String id) {
		return new VolumeResource(target.path("/{id}").pathParam("id", id));
	}

}
