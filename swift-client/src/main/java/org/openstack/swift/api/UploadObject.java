package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.model.ObjectForUpload;

public class UploadObject implements OpenStackCommand<Response>{

	private ObjectForUpload objectForUpload;
	
	public UploadObject(ObjectForUpload objectForUpload) {
		this.objectForUpload = objectForUpload;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
//		Invocation.Builder invocationBuilder = target.path(objectForUpload.getContainer()).path(objectForUpload.getName()).request(MediaType.APPLICATION_JSON);
//		for(String key : objectForUpload.getProperties().keySet()) {
//			invocationBuilder.header("x-object-meta-" + key, objectForUpload.getProperties().get(key));
//		}
//		return invocationBuilder.put(Entity.entity(objectForUpload.getInputStream(), MediaType.APPLICATION_OCTET_STREAM), Response.class);
		return null;
	}

}
