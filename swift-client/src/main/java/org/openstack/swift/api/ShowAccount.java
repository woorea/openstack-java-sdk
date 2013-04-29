package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class ShowAccount implements OpenStackCommand<Response>{

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
//		return target.request(MediaType.APPLICATION_JSON).head();
		return null;
	}

}
