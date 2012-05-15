package org.openstack.model.compute.nova.snapshot;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.Snapshot;

@XmlRootElement(name = "snapshot", namespace = "")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("snapshot")
public class NovaSnapshot implements Serializable, Snapshot {

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String status;

	@XmlAttribute(name = "size")
	@JsonProperty("size")
	private Integer sizeInGB;

	@XmlAttribute(name = "createdAt")
	@JsonProperty("createdAt")
	private String created;

	@XmlAttribute(name = "displayName")
	@JsonProperty("displayName")
	private String name;

	@XmlAttribute(name = "displayDescription")
	@JsonProperty("displayDescription")
	private String description;

	@XmlAttribute(name = "volumeId")
	private String volumeId;

	public NovaSnapshot() {

	}

	public NovaSnapshot(String id, String name, String volumeId) {
		this.id = id;
		this.name = name;
		this.volumeId = volumeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getStatus()
	 */
	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getSizeInGB()
	 */
	@Override
	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public void setSizeInGB(Integer sizeInGB) {
		this.sizeInGB = sizeInGB;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getCreated()
	 */
	@Override
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openstack.model.compute.nova.snapshot.Snapshot#getVolumeId()
	 */
	@Override
	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	@Override
	public String toString() {
		return "NovaSnapshot [id=" + id + ", status=" + status + ", sizeInGB="
				+ sizeInGB + ", created=" + created + ", name=" + name
				+ ", description=" + description + ", volumeId=" + volumeId
				+ "]";
	}

}
