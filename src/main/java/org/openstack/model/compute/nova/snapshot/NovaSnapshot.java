package org.openstack.model.compute.nova.snapshot;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.Snapshot;

import com.google.gson.annotations.SerializedName;


@XmlRootElement(name = "snapshot", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("snapshot")
public class NovaSnapshot implements Serializable, Snapshot {
	
	@XmlAttribute
	private Integer id;
	
	@XmlAttribute
	private String status;

	@XmlAttribute(name="size")
	@SerializedName("size")
	private Integer sizeInGB;
	
	@XmlAttribute
	private String availabilityZone;
	
	@XmlAttribute(name="createdAt")
	@SerializedName("createdAt")
	private String created;
	
	@XmlAttribute(name="displayName")
	@SerializedName("displayName")
	private String name;
	
	@XmlAttribute(name="displayDescription")
	@SerializedName("displayDescription")
	private String description;
	
	@XmlAttribute(name="volumeId")
	private Integer volumeId;
	
	public NovaSnapshot() {
		
	}
	
	public NovaSnapshot(Integer id, String name, Integer volumeId) {
		this.id = id;
		this.name = name;
		this.volumeId = volumeId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getStatus()
	 */
	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getSizeInGB()
	 */
	@Override
	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public void setSizeInGB(Integer sizeInGB) {
		this.sizeInGB = sizeInGB;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getAvailabilityZone()
	 */
	@Override
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getCreated()
	 */
	@Override
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getVolumeId()
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
		return "NovaSnapshot [id=" + id + ", status=" + status + ", sizeInGB="
				+ sizeInGB + ", availabilityZone=" + availabilityZone
				+ ", created=" + created + ", name=" + name + ", description="
				+ description + ", volumeId=" + volumeId + "]";
	}
	
}
