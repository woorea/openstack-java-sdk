package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("os-volume_upload_image")
public class ImageFromVolume implements Serializable {

	@JsonProperty("id")
	String id;
	@JsonProperty("updates_at")
	String updates_at;
	@JsonProperty("status")
	String status;
	@JsonProperty("display_description")
	String display_description;
	@JsonProperty("size")
	String size;
	@JsonProperty("volume_type")
	String volume_type;
	@JsonProperty("image_id")
	String image_id;
	@JsonProperty("container_format")
	String container_format;
	@JsonProperty("disk_format")
	String disk_format;
	@JsonProperty("image_name")
	String image_name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpdates_at() {
		return updates_at;
	}

	public void setUpdates_at(String updates_at) {
		this.updates_at = updates_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplay_description() {
		return display_description;
	}

	public void setDisplay_description(String display_description) {
		this.display_description = display_description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getVolume_type() {
		return volume_type;
	}

	public void setVolume_type(String volume_type) {
		this.volume_type = volume_type;
	}

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getContainer_format() {
		return container_format;
	}

	public void setContainer_format(String container_format) {
		this.container_format = container_format;
	}

	public String getDisk_format() {
		return disk_format;
	}

	public void setDisk_format(String disk_format) {
		this.disk_format = disk_format;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

}
