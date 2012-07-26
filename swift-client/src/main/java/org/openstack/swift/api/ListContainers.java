package org.openstack.swift.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.Container;

public class ListContainers implements SwiftCommand<List<Container>>{

	@Override
	public List<Container> execute(WebTarget target) {
		return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
	}

}
