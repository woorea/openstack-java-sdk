package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.volume.NovaVolume;
import org.openstack.model.compute.nova.volume.NovaVolumeList;
import org.openstack.model.compute.nova.volume.VolumeForCreate;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumesResource extends Resource {
	
	public VolumesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public VolumeList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaVolumeList.class);
	}
	
	/**
	 * Creates a new volume.
	 * 
	 * @param flavor
	 * @return
	 */
	public Volume post(VolumeForCreate volume) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(volume, MediaType.APPLICATION_JSON), NovaVolume.class);
	}

	public VolumeResource volume(String id) {
		return new VolumeResource(target.path("/{volumeId}").pathParam("volumeId", id), properties);
	}

}
