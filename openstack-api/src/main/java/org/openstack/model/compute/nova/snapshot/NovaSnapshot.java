package org.openstack.model.compute.nova.snapshot;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.Snapshot;


@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaSnapshot implements Serializable, Snapshot {
	
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
	private Integer volumeId;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getStatus()
	 */
	@Override
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getSizeInGB()
	 */
	@Override
	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public void setSizeInGB(Integer sizeInGB) {
		this.sizeInGB = sizeInGB;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getAvailabilityZone()
	 */
	@Override
	public Integer getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(Integer availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getCreated()
	 */
	@Override
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Snapshot#getVolumeId()
	 */
	@Override
	public Integer getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(Integer volumeId) {
		this.volumeId = volumeId;
	}

	@Override
	public String toString() {
		return "Volume [id=" + id + ", status=" + status + ", sizeInGB="
				+ sizeInGB + ", availabilityZone=" + availabilityZone
				+ ", type=" + type + ", created=" + created + ", name=" + name
				+ ", description=" + description + ", volumeId=" + volumeId
				+ ", metadata=" + volumeId + "]";
	}

	
	
}
