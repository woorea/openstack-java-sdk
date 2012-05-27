package org.openstack.model.compute.nova.aggregate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("aggregate")
public class Aggregate implements Serializable {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("availability_zone")
	private String availabiliyZone;
	
	private boolean deleted;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	@JsonProperty("operational_state")
	private String operationalState;
	
	@JsonProperty("deleted_at")
	private String deletedAt;

	@JsonProperty("hosts")
	private List<String> hosts = new ArrayList<String>();
	
	@JsonProperty("metadata")
	private Map<String, String> metadata = new HashMap<String, String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailabiliyZone() {
		return availabiliyZone;
	}

	public void setAvailabiliyZone(String availabiliyZone) {
		this.availabiliyZone = availabiliyZone;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(String operationalState) {
		this.operationalState = operationalState;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public List<String> getHosts() {
		return hosts;
	}

	public void setHosts(List<String> hosts) {
		this.hosts = hosts;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	
}
