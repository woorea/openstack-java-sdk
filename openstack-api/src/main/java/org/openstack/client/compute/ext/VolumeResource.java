package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

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
