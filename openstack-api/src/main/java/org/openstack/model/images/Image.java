package org.openstack.model.images;

import java.util.Date;
import java.util.Map;

public interface Image {

	public abstract String getUri();

	public abstract void setUri(String uri);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getDiskFormat();

	public abstract void setDiskFormat(String diskFormat);

	public abstract String getContainerFormat();

	public abstract void setContainerFormat(String containerFormat);

	public abstract Long getSize();

	public abstract void setSize(Long size);

	public abstract String getChecksum();

	public abstract void setChecksum(String checksum);

	public abstract String getCreatedAt();

	public abstract void setCreatedAt(String createdAt);

	public abstract String getUpdatedAt();

	public abstract void setUpdatedAt(String updatedAt);

	public abstract Date getDeletedAt();

	public abstract void setDeletedAt(Date deletedAt);

	public abstract String getStatus();

	public abstract void setStatus(String status);

	public abstract Boolean isPublic();

	public abstract void setPublic(Boolean isPublic);

	public abstract Integer getMinRam();

	public abstract void setMinRam(Integer minRam);

	public abstract Integer getMinDisk();

	public abstract void setMinDisk(Integer minDisk);

	public abstract String getOwner();

	public abstract void setOwner(String owner);

	public abstract Boolean isDeleted();

	public abstract void setDeleted(Boolean deleted);

	public abstract Boolean isProtected();

	public abstract void setProtected(Boolean isProtected);

	public abstract String getId();

	public abstract void setId(String id);

	public abstract Map<String, Object> getProperties();

}