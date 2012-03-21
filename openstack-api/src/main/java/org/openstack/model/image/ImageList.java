package org.openstack.model.image;

import java.util.List;

import org.openstack.model.image.glance.GlanceImage;

public interface ImageList {

	public abstract List<GlanceImage> getList();

}