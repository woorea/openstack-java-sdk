package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;

public class DownloadObject extends OpenStackRequest {

	private String containerName;
	
	private String objectName;
	
	public DownloadObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
//		Response response = target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).get();
//		ObjectDownload objectDownload = new ObjectDownload();
//		objectDownload.setInputStream((InputStream) response.getEntity());
//		return objectDownload;
	}

}
