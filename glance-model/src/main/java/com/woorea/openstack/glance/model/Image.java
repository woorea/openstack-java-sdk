package com.woorea.openstack.glance.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("image")
public class Image implements Serializable {

	private String id;

	private String uri;
	
	private String name;
	
	@JsonProperty("disk_format")
	private String diskFormat;
	
	@JsonProperty("container_format")
	private String containerFormat;
	
	private Long size;
	
	private String checksum;
	
	@JsonProperty("created_at")
	private Calendar createdAt;
	
	@JsonProperty("updated_at")
	private Calendar updatedAt;
	
	@JsonProperty("deleted_at")
	private Calendar deletedAt;
	
	private String status;
	
	@JsonProperty("is_public")
	private boolean isPublic;
	
	@JsonProperty("min_ram")
	private Integer minRam;
	
	@JsonProperty("min_disk")
	private Integer minDisk;
	
	private String owner;
	
	@JsonProperty("deleted")
	private boolean isDeleted;
	
	@JsonProperty("protected")
	private boolean isProtected;
	
	private Map<String, Object> properties;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the diskFormat
	 */
	public String getDiskFormat() {
		return diskFormat;
	}

	/**
	 * @param diskFormat the diskFormat to set
	 */
	public void setDiskFormat(String diskFormat) {
		this.diskFormat = diskFormat;
	}

	/**
	 * @return the containerFormat
	 */
	public String getContainerFormat() {
		return containerFormat;
	}

	/**
	 * @param containerFormat the containerFormat to set
	 */
	public void setContainerFormat(String containerFormat) {
		this.containerFormat = containerFormat;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}

	/**
	 * @param checksum the checksum to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the deletedAt
	 */
	public Calendar getDeletedAt() {
		return deletedAt;
	}

	/**
	 * @param deletedAt the deletedAt to set
	 */
	public void setDeletedAt(Calendar deletedAt) {
		this.deletedAt = deletedAt;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the isPublic
	 */
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * @param isPublic the isPublic to set
	 */
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @return the minRam
	 */
	public Integer getMinRam() {
		return minRam;
	}

	/**
	 * @param minRam the minRam to set
	 */
	public void setMinRam(Integer minRam) {
		this.minRam = minRam;
	}

	/**
	 * @return the minDisk
	 */
	public Integer getMinDisk() {
		return minDisk;
	}

	/**
	 * @param minDisk the minDisk to set
	 */
	public void setMinDisk(Integer minDisk) {
		this.minDisk = minDisk;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the isProtected
	 */
	public boolean isProtected() {
		return isProtected;
	}

	/**
	 * @param isProtected the isProtected to set
	 */
	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	/**
	 * @return the properties
	 */
	public Map<String, Object> getProperties() {
		if(properties == null) {
			properties = new HashMap<String, Object>();
		}
		return properties;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Image [id=" + id + ", uri=" + uri + ", name=" + name
				+ ", diskFormat=" + diskFormat + ", containerFormat="
				+ containerFormat + ", size=" + size + ", checksum=" + checksum
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", deletedAt=" + deletedAt + ", status=" + status
				+ ", isPublic=" + isPublic + ", minRam=" + minRam
				+ ", minDisk=" + minDisk + ", owner=" + owner + ", isDeleted="
				+ isDeleted + ", isProtected=" + isProtected + ", properties="
				+ properties + "]";
	}
	
}
