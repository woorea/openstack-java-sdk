package org.openstack.api.compute.ext;

import org.openstack.api.common.Resource;

public class VolumeResource extends Resource {

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
