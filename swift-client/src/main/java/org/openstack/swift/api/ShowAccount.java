package org.openstack.swift.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

public class ShowAccount implements SwiftCommand<Response>{

	@Override
	public Response execute(WebTarget target) {
		return target.request(MediaType.APPLICATION_JSON).head();
	}

}
