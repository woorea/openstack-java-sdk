package org.openstack.model.images;

import java.util.List;

public interface ImageList extends Iterable<Image> {

	public abstract List<Image> getList();

}