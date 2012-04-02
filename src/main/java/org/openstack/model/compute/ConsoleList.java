package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.NovaConsole;

public interface ConsoleList {

	List<Console> getList();

}