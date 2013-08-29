package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("aggreagate")
public class HostAggregate implements Serializable {
	
	private String id;

	private String name;
	
	@JsonProperty("availability_zone")
	private String availabilityZone;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	@JsonProperty("deleted_at")
	private String deletedAt;
	
	private Boolean deleted;
	
	private List<String> hosts;
	
	private Map<String, String> metadata;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the availabilityZone
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @return the deletedAt
	 */
	public String getDeletedAt() {
		return deletedAt;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @return the hosts
	 */
	public List<String> getHosts() {
		return hosts;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HostAggregate [id=" + id + ", name=" + name
				+ ", availabilityZone=" + availabilityZone + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", deletedAt="
				+ deletedAt + ", deleted=" + deleted + ", hosts=" + hosts
				+ ", metadata=" + metadata + "]";
	}
	
}
