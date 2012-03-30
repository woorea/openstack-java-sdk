package org.openstack.model.compute.nova.volume;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.Metadata;
import org.openstack.model.compute.Volume;

import com.google.gson.annotations.SerializedName;


@XmlRootElement(name = "volume", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("volume")
public class NovaVolumeForCreate implements Serializable, VolumeForCreate {

	@XmlAttribute(name="size")
	@SerializedName("size")
	private Integer sizeInGB;
	
	@XmlAttribute(name="availabilityZone")
	@SerializedName("availability_zone")
	private String availabilityZone;
	
	@XmlAttribute(name="displayName")
	@SerializedName("display_name")
	private String name;
	
	@XmlAttribute(name="displayDescription")
	@SerializedName("display_description")
	private String description;

	
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

	@Override
	public String toString() {
		return "NovaVolumeForCreate [sizeInGB=" + sizeInGB
				+ ", availabilityZone=" + availabilityZone + ", name=" + name
				+ ", description=" + description + "]";
	}

}
