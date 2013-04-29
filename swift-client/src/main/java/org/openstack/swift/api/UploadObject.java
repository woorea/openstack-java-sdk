package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.model.ObjectForUpload;

public class UploadObject extends OpenStackRequest {

	private ObjectForUpload objectForUpload;
	
	public UploadObject(ObjectForUpload objectForUpload) {
		this.objectForUpload = objectForUpload;
//		Invocation.Builder invocationBuilder = target.path(objectForUpload.getContainer()).path(objectForUpload.getName()).request(MediaType.APPLICATION_JSON);
//		for(String key : objectForUpload.getProperties().keySet()) {
//			invocationBuilder.header("x-object-meta-" + key, objectForUpload.getProperties().get(key));
//		}
//		return invocationBuilder.put(Entity.entity(objectForUpload.getInputStream(), MediaType.APPLICATION_OCTET_STREAM), Response.class);
	}

}
