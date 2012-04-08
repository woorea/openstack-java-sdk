package org.openstack.model.compute;

import java.util.List;

public interface ImageList extends Iterable<Image> {

	List<Image> getList();

}