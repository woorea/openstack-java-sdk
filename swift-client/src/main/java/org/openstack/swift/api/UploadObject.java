package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.ObjectForUpload;

public class UploadObject implements SwiftCommand<Response>{

	private ObjectForUpload objectForUpload;
	
	public UploadObject(ObjectForUpload objectForUpload) {
		this.objectForUpload = objectForUpload;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return execute(target, null);
	}

	@Override
	public Response execute(WebTarget target, String token) {
		Invocation.Builder invocationBuilder = target.path(objectForUpload.getContainer()).path(objectForUpload.getName()).request(MediaType.APPLICATION_JSON);
		for(String key : objectForUpload.getProperties().keySet()) {
			invocationBuilder.header("x-object-meta-" + key, objectForUpload.getProperties().get(key));
		}
		
		if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }
		
		return invocationBuilder.put(Entity.entity(objectForUpload.getInputStream(), MediaType.APPLICATION_OCTET_STREAM), Response.class);
	}

}
