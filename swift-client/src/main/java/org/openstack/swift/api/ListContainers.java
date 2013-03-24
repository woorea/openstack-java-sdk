package org.openstack.swift.api;

import java.util.List;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.Container;

public class ListContainers implements SwiftCommand<List<Container>>{

	@Override
	public List<Container> execute(OpenStackClientConnector connector, OpenStackRequest request) {
		//return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
		return null;
	}

}
