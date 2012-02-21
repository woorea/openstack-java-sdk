package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Metadata;

public class ImageResource extends Resource {

	private Image representation;

	public Image show() {
		return representation;
	}

	public void delete() {
		resource().delete();
	}

	public Metadata metadata() {
		// /metadata
		return new Metadata();
	}

	public ImageResource get() {
		representation = resource().get(Image.class);
		return this;
	}

}
