package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.NovaFlavor;

public interface FlavorList {

	List<Flavor> getList();

}