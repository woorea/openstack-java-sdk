package org.openstack.api.compute.ext;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class VolumeResource extends Resource {

	public VolumeResource(Target target) {
		super(target);
	}

	/**
	 * Return a single volume type item.
	 * 
	 * @return
	 */
	public String show() {
		return resource().get(String.class);
	}

	public void delete() {
		 resource().delete();
	}
	
}
