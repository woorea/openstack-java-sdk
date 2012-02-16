package org.openstack.model.compute;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class Snapshot implements Serializable {
	
	@XmlAttribute
	private Integer id;
	
	@XmlAttribute
	private Integer status;

	@XmlAttribute(name="size")
	private Integer sizeInGB;
	
	@XmlAttribute(name="availabilityZone")
	private Integer availabilityZone;
	
	@XmlAttribute(name="volumeType")
	private String type;
	
	@XmlAttribute(name="createdAt")
	private String created;
	
	@XmlAttribute(name="displayName")
	private String name;
	
	@XmlAttribute(name="displayDescription")
	private String description;
	
	@XmlAttribute(name="snapshotId")
	private String snapshotId;
	
	@XmlElement(name="metadata")
	private Metadata metadata;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public void setSizeInGB(Integer sizeInGB) {
		this.sizeInGB = sizeInGB;
	}

	public Integer getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(Integer availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "Volume [id=" + id + ", status=" + status + ", sizeInGB="
				+ sizeInGB + ", availabilityZone=" + availabilityZone
				+ ", type=" + type + ", created=" + created + ", name=" + name
				+ ", description=" + description + ", snapshotId=" + snapshotId
				+ ", metadata=" + metadata + "]";
	}

	
	
}
