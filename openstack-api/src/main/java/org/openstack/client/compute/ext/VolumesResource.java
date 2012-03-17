package org.openstack.client.compute.ext;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;
import org.openstack.model.compute.NovaVolumeList;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumesResource extends Resource {
	
	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public NovaVolumeList list(boolean detail) {
		RequestBuilder r = detail ? resource("detail") : resource();
		return r.get(NovaVolumeList.class);
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
		return buildChildResource(id, VolumeResource.class);
	}

}
