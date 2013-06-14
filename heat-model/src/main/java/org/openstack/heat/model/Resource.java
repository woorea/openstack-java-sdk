package org.openstack.heat.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
@JsonRootName("resource")
public class Resource implements Serializable {
	private static final long serialVersionUID = 2242093632995902190L;
	@JsonProperty("physical_resource_id")
	private String id;
	@JsonProperty("logical_resource_id")
	private String name;
	@JsonProperty("resource_status")
	private String status;
	@JsonProperty("resource_status_reason")
	private String statusReason;
	@JsonProperty("resource_type")
	private String type;
	@JsonProperty("updated_time")
	private String updatedAt;
	private String description;
	private List<Link> links;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	@Override
	public String toString() {
		return "resource:{" + id + ", name=" + name + ", status=" + status
				+ ", statusReason=" + statusReason + ", type=" + type
				+ ", updatedAt=" + updatedAt + ", description=" + description
				+ ", links=" + links + "}";
	}
}
