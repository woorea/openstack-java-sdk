package org.openstack.swift.api;

import java.io.InputStream;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.ObjectDownload;

public class DownloadObject implements SwiftCommand<ObjectDownload> {

	private final String containerName;
	
	private final String objectName;
	
	public DownloadObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public ObjectDownload execute(WebTarget target) {
		return execute(target, null);
	}

	@Override
	public ObjectDownload execute(WebTarget target, String token) {
		Invocation.Builder invocationBuilder = target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON);
        
        if(token != null) {
        	invocationBuilder.header(REQ_HEADER_AUTH_TOKEN, token);
        }
        
		Response response = invocationBuilder.get();
		ObjectDownload objectDownload = new ObjectDownload();
		objectDownload.setInputStream((InputStream) response.getEntity());
		return objectDownload;
	}

}
