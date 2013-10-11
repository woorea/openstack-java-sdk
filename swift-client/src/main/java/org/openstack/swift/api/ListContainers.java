package org.openstack.swift.api;

import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.Container;

public class ListContainers implements SwiftCommand<List<Container>>{

	@Override
	public List<Container> execute(WebTarget target) {
		return execute(target, null);
	}

	@Override
	public List<Container> execute(WebTarget target, String token) {
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        
        if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }
        
        return invocationBuilder.get(new GenericType<List<Container>>(){});
	}

}
