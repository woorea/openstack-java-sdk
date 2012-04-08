package org.openstack.model.compute;

import java.util.List;

public interface FlavorList extends Iterable<Flavor> {

	List<Flavor> getList();

}