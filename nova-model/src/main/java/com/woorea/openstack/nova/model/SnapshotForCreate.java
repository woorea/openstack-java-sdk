package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("snapshot")
public class SnapshotForCreate implements Serializable {
	
	@JsonProperty("volume_id")
	private String volumeId;
	
	private Boolean force;
	
	@JsonProperty("display_name")
	private String name;

	@JsonProperty("display_description")
	private String description;

	/**
	 * @return the volumeId
	 */
	public String getVolumeId() {
		return volumeId;
	}

	/**
	 * @param volumeId the volumeId to set
	 */
	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	/**
	 * @return the force
	 */
	public Boolean getForce() {
		return force;
	}

	/**
	 * @param force the force to set
	 */
	public void setForce(Boolean force) {
		this.force = force;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SnapshotForCreate [volumeId=" + volumeId + ", force=" + force
				+ ", name=" + name + ", description=" + description + "]";
	}

}
