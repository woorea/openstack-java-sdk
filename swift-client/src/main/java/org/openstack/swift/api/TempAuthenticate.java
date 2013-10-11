package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

/**
 * Perform TempAuth authentication
 * 
 * @author Robin Bramley
 */
public class TempAuthenticate implements SwiftCommand<Response>{

    private static final String REQ_HEADER_STORAGE_USER = "X-Storage-User";
    private static final String REQ_HEADER_STORAGE_PASS = "X-Storage-Pass";
    public static final String RES_HEADER_STORAGE_URL = "X-Storage-Url";
    public static final String RES_HEADER_AUTH_TOKEN = "X-Auth-Token";
    
    private String storageUser;
    
	private String storagePass;

	public TempAuthenticate(String storageUser, String storagePass) {
		this.storageUser = storageUser;
        this.storagePass = storagePass;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return execute(target, null);
	}

	@Override
	public Response execute(WebTarget target, String token) {
		Invocation.Builder invocationBuilder = target.request();
        
		invocationBuilder.header(REQ_HEADER_STORAGE_USER, storageUser);
        invocationBuilder.header(REQ_HEADER_STORAGE_PASS, storagePass);
        
        if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }
        
        return invocationBuilder.get();
	}

}
