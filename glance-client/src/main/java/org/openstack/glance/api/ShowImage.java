package org.openstack.glance.api;

import java.util.Calendar;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.Image;

public class ShowImage implements GlanceCommand<Image> {
	
	private String id;
	
	public ShowImage(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		/*
		Response response = target.path("images").path(id).request(MediaType.APPLICATION_JSON).head();
		Image image = new Image();
		image.setId(response.getHeaderString("X-Image-Meta-Id"));
		image.setUri(response.getHeaderString("Location"));
		image.setName(response.getHeaderString("X-Image-Meta-Name"));
		image.setDiskFormat(response.getHeaderString("X-Image-Meta-Disk_format"));
		image.setContainerFormat(response.getHeaderString("X-Image-Meta-Container_format"));
		image.setSize(asLong(response.getHeaderString("X-Image-Meta-Size")));
		image.setChecksum(response.getHeaderString("X-Image-Meta-Checksum"));
		image.setCreatedAt(asCalendar(response.getHeaderString("X-Image-Meta-Created_at")));
		image.setUpdatedAt(asCalendar(response.getHeaderString("X-Image-Meta-Updated_at")));
		image.setDeletedAt(asCalendar(response.getHeaderString("X-Image-Meta-Deleted_at")));
		image.setDeleted(asBoolean(response.getHeaderString("X-Image-Meta-Deleted")));
		image.setStatus(response.getHeaderString("X-Image-Meta-Status"));
		image.setProtected(asBoolean(response.getHeaderString("X-Image-Meta-Protected")));
		image.setPublic(asBoolean(response.getHeaderString("X-Image-Meta-Is_public")));
		image.setMinRam(asInteger(response.getHeaderString("X-Image-Meta-Min_ram")));
		image.setMinDisk(asInteger(response.getHeaderString("X-Image-Meta-Min_disk")));
		image.setOwner(response.getHeaderString("X-Image-Meta-Owner"));
		for(String key : response.getMetadata().keySet()) {
			if(key.startsWith("X-Image-Meta-Property-")) {
				image.getProperties().put(key.substring(22), response.getHeaderString(key));
			}
		}
		return image;
		*/
		return null;
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
