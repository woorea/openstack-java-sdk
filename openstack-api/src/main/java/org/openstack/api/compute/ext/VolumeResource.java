package org.openstack.api.compute.ext;

import java.util.HashMap;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaVolume;

public class VolumeResource extends Resource {

	public VolumeResource(Target target) {
		super(target);
	}

	/**
	 * Return a single volume type item.
	 * 
	 * @return
	 */
	public NovaVolume get(HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaVolume.class);
	}

	public void delete(HashMap<String, Object> properties) {
		target.request().delete();
	}
	
}
