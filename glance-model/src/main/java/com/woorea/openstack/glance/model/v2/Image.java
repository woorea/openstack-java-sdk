package com.woorea.openstack.glance.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Calendar;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Serializable {

	private String id;

	private String self;
	
	private String name;

	private String file;
	
	@JsonProperty("disk_format")
	private String diskFormat;
	
	@JsonProperty("container_format")
	private String containerFormat;
	
	private Long size;

	@JsonProperty("virtual_size")
	private Long virtualSize;
	
	private String checksum;
	
	@JsonProperty("created_at")
	private Calendar createdAt;
	
	@JsonProperty("updated_at")
	private Calendar updatedAt;

	private String status;

	private String visibility;
	
	@JsonProperty("min_ram")
	private Integer minRam;
	
	@JsonProperty("min_disk")
	private Integer minDisk;
	
	private String owner;

	@JsonProperty("protected")
	private boolean isProtected;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiskFormat() {
		return diskFormat;
	}

	public void setDiskFormat(String diskFormat) {
		this.diskFormat = diskFormat;
	}

	public String getContainerFormat() {
		return containerFormat;
	}

	public void setContainerFormat(String containerFormat) {
		this.containerFormat = containerFormat;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getVirtualSize() {
		return virtualSize;
	}

	public void setVirtualSize(Long virtualSize) {
		this.virtualSize = virtualSize;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMinRam() {
		return minRam;
	}

	public void setMinRam(Integer minRam) {
		this.minRam = minRam;
	}

	public Integer getMinDisk() {
		return minDisk;
	}

	public void setMinDisk(Integer minDisk) {
		this.minDisk = minDisk;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean aProtected) {
		isProtected = aProtected;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "Image{" +
				"id='" + id + '\'' +
				", self='" + self + '\'' +
				", name='" + name + '\'' +
				", file='" + file + '\'' +
				", diskFormat='" + diskFormat + '\'' +
				", containerFormat='" + containerFormat + '\'' +
				", size=" + size +
				", virtualSize=" + virtualSize +
				", checksum='" + checksum + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", status='" + status + '\'' +
				", visibility='" + visibility + '\'' +
				", minRam=" + minRam +
				", minDisk=" + minDisk +
				", owner='" + owner + '\'' +
				", isProtected=" + isProtected +
				'}';
	}
}
