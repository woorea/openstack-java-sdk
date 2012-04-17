package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.nova.volume.NovaVolume;

public class VolumeResource extends Resource {

	public VolumeResource(Target target, Properties properties) {
		super(target, properties);
	}

	/**
	 * Return a single volume type item.
	 * 
	 * @return
	 */
	public Volume get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaVolume.class);
	}

	public void delete() {
		target.request().delete();
	}
	
}
