package org.openstack.swift.api;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

public class ShowContainer implements SwiftCommand<Response>{

	private String containerName;
	
	public ShowContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return execute(target, null);
	}

	@Override
	public Response execute(WebTarget target, String token) {
		Invocation.Builder invocationBuilder = target.path(containerName).request(MediaType.APPLICATION_JSON);
        
        if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }
        
        return invocationBuilder.head();
	}

}
