package org.openstack.swift.api;

import java.util.List;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.model.Container;

public class ListContainers implements OpenStackCommand<List<Container>>{

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		//return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
		return null;
	}

}
