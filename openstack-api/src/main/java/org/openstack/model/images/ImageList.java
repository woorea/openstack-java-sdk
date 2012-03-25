package org.openstack.model.images;

import java.util.List;

import org.openstack.model.images.glance.GlanceImage;

public interface ImageList {

	public abstract List<GlanceImage> getList();

}