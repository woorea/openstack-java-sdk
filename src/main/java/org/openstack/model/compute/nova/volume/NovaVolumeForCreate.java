package org.openstack.model.compute.nova.volume;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;


@XmlRootElement(name = "volume", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("volume")
public class NovaVolumeForCreate implements Serializable, VolumeForCreate {

	@XmlAttribute(name="size")
	@JsonProperty("size")
	private Integer sizeInGB;
	
	@XmlAttribute(name="availability_zone")
	@JsonProperty("availability_zone")
	private String availabilityZone;
	
	@XmlAttribute(name="display_name")
	@JsonProperty("display_name")
	private String name;
	
	@XmlAttribute(name="display_description")
	@JsonProperty("display_description")
	private String description;
	
	@JsonProperty("snapshot_id")
	private Integer snapshotId;
	
	private Map<String, String> metadata;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.volume.VolumeForCreate#getSizeInGB()
	 */
	@Override
	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public void setSizeInGB(Integer sizeInGB) {
		this.sizeInGB = sizeInGB;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.volume.VolumeForCreate#getAvailabilityZone()
	 */
	@Override
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
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
	public Integer getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(Integer snapshotId) {
		this.snapshotId = snapshotId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getMetadata()
	 */
	@Override
	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "NovaVolumeForCreate [sizeInGB=" + sizeInGB
				+ ", availabilityZone=" + availabilityZone + ", name=" + name
				+ ", description=" + description + "]";
	}

}
