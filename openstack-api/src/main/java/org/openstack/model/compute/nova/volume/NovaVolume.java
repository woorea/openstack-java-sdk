package org.openstack.model.compute.nova.volume;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.Metadata;
import org.openstack.model.compute.Volume;


@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaVolume implements Serializable, Volume {
	
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

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getStatus()
	 */
	@Override
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getSizeInGB()
	 */
	@Override
	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public void setSizeInGB(Integer sizeInGB) {
		this.sizeInGB = sizeInGB;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getAvailabilityZone()
	 */
	@Override
	public Integer getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(Integer availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getCreated()
	 */
	@Override
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getSnapshotId()
	 */
	@Override
	public String getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getMetadata()
	 */
	@Override
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
