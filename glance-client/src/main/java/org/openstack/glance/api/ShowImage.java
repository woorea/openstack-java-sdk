package org.openstack.glance.api;

import java.util.Calendar;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.Image;

public class ShowImage implements GlanceCommand<Image> {
	
	private String id;
	
	public ShowImage(String id) {
		this.id = id;
	}

	@Override
	public Image execute(WebTarget target) {
		Response response = target.path("images").path(id).request(MediaType.APPLICATION_JSON).head();
		Image image = new Image();
		image.setId(response.getHeader("X-Image-Meta-Id"));
		image.setUri(response.getHeader("Location"));
		image.setName(response.getHeader("X-Image-Meta-Name"));
		image.setDiskFormat(response.getHeader("X-Image-Meta-Disk_format"));
		image.setContainerFormat(response.getHeader("X-Image-Meta-Container_format"));
		image.setSize(asInteger(response.getHeader("X-Image-Meta-Size")));
		image.setChecksum(response.getHeader("X-Image-Meta-Checksum"));
		image.setCreatedAt(asCalendar(response.getHeader("X-Image-Meta-Created_at")));
		image.setUpdatedAt(asCalendar(response.getHeader("X-Image-Meta-Updated_at")));
		image.setDeletedAt(asCalendar(response.getHeader("X-Image-Meta-Deleted_at")));
		image.setDeleted(asBoolean(response.getHeader("X-Image-Meta-Deleted")));
		image.setStatus(response.getHeader("X-Image-Meta-Status"));
		image.setProtected(asBoolean(response.getHeader("X-Image-Meta-Protected")));
		image.setPublic(asBoolean(response.getHeader("X-Image-Meta-Is_public")));
		image.setMinRam(asInteger(response.getHeader("X-Image-Meta-Min_ram")));
		image.setMinDisk(asInteger(response.getHeader("X-Image-Meta-Min_disk")));
		image.setOwner(response.getHeader("X-Image-Meta-Owner"));
		for(String key : response.getMetadata().keySet()) {
			if(key.startsWith("X-Image-Meta-Property-")) {
				image.getProperties().put(key.substring(22), response.getHeader(key));
			}
		}
		return image;
	}
	
	private Calendar asCalendar(String calendarString) {
		return null;
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
	
}
