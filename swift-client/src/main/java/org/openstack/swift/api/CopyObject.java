package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

/**
 * Copy an object.
 * "do a PUT to the new object (the target) location, but add the 'X-Copy-From' header to designate the source of the data"
 * 
 * @author Robin Bramley
 */
public class CopyObject implements SwiftCommand<Response>{

    private static final String DELIMITER = "/";

    private static final String REQ_HEADER_COPY_FROM = "X-Copy-From";

    private String sourceContainerName;
    
	private String sourceObjectName;

	private String destContainerName;
	
	private String destObjectName;
    
    private String mimeType;

	public CopyObject(String sourceContainerName, String sourceObjectName, String destContainerName, String destObjectName, String mimeType) {
		this.sourceContainerName = sourceContainerName;
        this.sourceObjectName = sourceObjectName;
        this.destContainerName = destContainerName;
        this.destObjectName = destObjectName;
        this.mimeType = mimeType;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return execute(target, null);
	}

	@Override
	public Response execute(WebTarget target, String token) {
        // set up the value for the X-Copy-From header
        StringBuilder sb = new StringBuilder(2
                                             + sourceContainerName.length()
                                             + sourceObjectName.length())
            .append(DELIMITER).append(sourceContainerName)
            .append(DELIMITER).append(sourceObjectName);
        String source = sb.toString();
        
		Invocation.Builder invocationBuilder = target.path(destContainerName).path(destObjectName).request();
        
        invocationBuilder.header(REQ_HEADER_COPY_FROM, source);
        if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }

		return invocationBuilder.put(Entity.entity("", mimeType));
	}
}
