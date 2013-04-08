package org.openstack.swift.api;

import java.util.List;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.Container;

public class ListContainers implements SwiftCommand<List<Container>>{

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		//return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
		return null;
	}

}
