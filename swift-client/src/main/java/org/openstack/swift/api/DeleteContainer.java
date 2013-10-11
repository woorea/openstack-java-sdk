package org.openstack.swift.api;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

public class DeleteContainer implements SwiftCommand<Response>{

	private final String containerName;
	
	public DeleteContainer(String containerName) {
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
        
        return invocationBuilder.delete();
	}

}
