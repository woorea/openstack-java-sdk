package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.openstack.swift.SwiftCommand;

public class CreateDirectory implements SwiftCommand<Void> {

	private final String container;
	
	private final String path;
	
	public CreateDirectory(String container, String path) {
		this.container = container;
		this.path = path;
	}

	@Override
	public Void execute(WebTarget target) {
		
		return execute(target, null);
	}

	@Override
	public Void execute(WebTarget target, String token) {
		// TODO Auto-generated method stub
		Invocation.Builder invocationBuilder = target.path(container).path(path).request();
        
        if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }
		
		invocationBuilder.put(Entity.entity(new byte[1],"application/directory"));
		
		return null;
	}
}
