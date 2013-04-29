package org.openstack.glance.api;

import java.util.Calendar;

import org.openstack.base.client.OpenStackRequest;

public class DownloadImage extends OpenStackRequest {

	private String id;
	
	public DownloadImage(String id) {
		this.id = id;
		/*
		Response response = target.path("images").path(id).request(MediaType.APPLICATION_OCTET_STREAM).head();
		Image image = new Image();
		image.setUri(response.getHeaderString("x-image-meta-uri"));
		image.setName(response.getHeaderString("x-image-meta-name"));
		image.setDiskFormat(response.getHeaderString("x-image-meta-disk_format"));
		image.setContainerFormat(response.getHeaderString("x-image-meta-container_format"));
		image.setSize(asLong(response.getHeaderString("x-image-meta-size")));
		image.setChecksum(response.getHeaderString("x-image-meta-checksum"));
		image.setCreatedAt(asCalendar(response.getHeaderString("x-image-meta-create_at")));
		image.setUpdatedAt(asCalendar(response.getHeaderString("x-image-meta-updated_at")));
		image.setDeletedAt(asCalendar(response.getHeaderString("x-image-meta-deleted_at")));
		image.setStatus(response.getHeaderString("x-image-meta-status"));
		image.setPublic(asBoolean(response.getHeaderString("x-image-meta-is-public")));
		image.setMinRam(asInteger(response.getHeaderString("x-image-meta-min-ram")));
		image.setMinDisk(asInteger(response.getHeaderString("x-image-meta-min-disk")));
		image.setOwner(response.getHeaderString("x-image-meta-owner"));
		image.setName(response.getHeaderString("x-image-meta-owner"));
		for(String key : response.getMetadata().keySet()) {
			if(key.startsWith("x-image-meta-property-")) {
				image.getProperties().put(key.substring(22), response.getHeaderString(key));
			}
		}
		ImageDownload imageDownload = new ImageDownload();
		imageDownload.setImage(image);
		imageDownload.setInputStream((InputStream) response.getEntity());
		return imageDownload;
		*/
	}
	
	private Calendar asCalendar(String calendarString) {
		return Calendar.getInstance();
	}
	
	private Integer asInteger(String integerString) {
		if(integerString != null) {
			return Integer.parseInt(integerString);
		}
		return 0;
	}
	
	private Boolean asBoolean(String booleanString) {
		if(booleanString != null) {
			return Boolean.parseBoolean(booleanString);
		}
		return Boolean.FALSE;
	}
	
	private Long asLong(String longString) {
		if(longString != null) {
			return Long.parseLong(longString);
		}
		return 0L;
	}

}
