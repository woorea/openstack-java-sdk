package org.openstack.model.compute;

import java.util.List;

public interface ServerList extends Iterable<Server> {

	List<Server> getList();

}