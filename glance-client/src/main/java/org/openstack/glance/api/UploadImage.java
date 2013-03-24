package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.ImageForUpload;

public class UploadImage implements GlanceCommand<Image>{
	
	private ImageForUpload imageForUpload;
	
	public UploadImage(ImageForUpload imageForUpload) {
		this.imageForUpload = imageForUpload;
	}

	@Override
	public Image execute(OpenStackClientConnector connector, OpenStackRequest request) {
		/*
		Invocation.Builder invocationBuilder = target.path("images").request(MediaType.APPLICATION_JSON);
		if(imageForUpload.getName() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-name", imageForUpload.getName());
		}
		if(imageForUpload.getDiskFormat() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-disk_format", imageForUpload.getDiskFormat());
		}
		if(imageForUpload.getContainerFormat() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-container_format", imageForUpload.getContainerFormat());
		}
		if(imageForUpload.getId() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-id", imageForUpload.getId());
		}
		if(imageForUpload.getStore() != null) {
			//file,s3,swift
			invocationBuilder = invocationBuilder.header("x-image-meta-store", imageForUpload.getStore());
		}
		if(imageForUpload.getSize() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-size", imageForUpload.getSize());
		}
		if(imageForUpload.getChecksum() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-checksum", imageForUpload.getChecksum());
		}
		if(imageForUpload.isPublic()) {
			invocationBuilder = invocationBuilder.header("x-image-meta-is-public", imageForUpload.isPublic());
		}
		if(imageForUpload.getOwner() != null) {
			invocationBuilder = invocationBuilder.header("x-image-meta-owner", imageForUpload.getOwner());
		}
		for(String key : imageForUpload.getProperties().keySet()) {
			imageForUpload.getProperties().put("x-image-meta-property-" + key, imageForUpload.getProperties().get(key));
		}
		return invocationBuilder.post(Entity.entity(imageForUpload.getInputStream(), MediaType.APPLICATION_OCTET_STREAM), Image.class);
		*/
		return null;
	}

}
