package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.volume.NovaVolumeList;

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
	public VolumeList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaVolumeList.class);
	}
	
	public Volume post(Volume volume) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(volume, MediaType.APPLICATION_JSON), Volume.class);
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
