package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.NovaImage;

public interface ImageList {

	List<Image> getList();

}