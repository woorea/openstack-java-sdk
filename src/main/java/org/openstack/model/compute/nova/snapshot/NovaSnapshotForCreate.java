package org.openstack.model.compute.nova.snapshot;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.SnapshotForCreate;


@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("snapshot")
public class NovaSnapshotForCreate implements Serializable, SnapshotForCreate {
	
	@XmlAttribute(name="volume_id")
	@JsonProperty("volume_id")
	private Integer volumeId;
	
	@XmlAttribute
	private Boolean force;
	
	@XmlAttribute(name="display_name")
	@JsonProperty("display_name")
	private String name;
	
	@XmlAttribute(name="display_description")
	@JsonProperty("display_description")
	private String description;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.SnapshotForCreate#getVolumeId()
	 */
	@Override
	public Integer getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(Integer volumeId) {
		this.volumeId = volumeId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.SnapshotForCreate#getForce()
	 */
	@Override
	public Boolean getForce() {
		return force;
	}

	public void setForce(Boolean force) {
		this.force = force;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.SnapshotForCreate#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.snapshot.SnapshotForCreate#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
