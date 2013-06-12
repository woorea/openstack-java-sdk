package org.openstack.heat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
@JsonRootName("event")
public class Event implements Serializable{
	private static final long serialVersionUID = 7779947747496478239L;
	private String id;
	@JsonProperty("resource_type")
	private String resourceType;
	@JsonProperty("physical_resource_id")
	private String resourceID;
	@JsonProperty("logical_resource_id")
	private String resourceName;
	@JsonProperty("resource_status")
	private String resourceStatus;
	@JsonProperty("resource_status_reason")
	private String resourceStatusReason;
	private List<Link> links;
	@JsonProperty("event_time")
	private String time;
	@JsonProperty("resource_properties")
	private Map<String,String> resourceProperties;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourceID() {
		return resourceID;
	}
	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceStatus() {
		return resourceStatus;
	}
	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus;
	}
	public String getResourceStatusReason() {
		return resourceStatusReason;
	}
	public void setResourceStatusReason(String resourceStatusReason) {
		this.resourceStatusReason = resourceStatusReason;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Map<String, String> getResourceProperties() {
		return resourceProperties;
	}
	public void setResourceProperties(Map<String, String> resourceProperties) {
		this.resourceProperties = resourceProperties;
	}
	@Override
	public String toString() {
		return "event:{id=" + id + ", resourceType=" + resourceType
				+ ", resourceID=" + resourceID + ", resourceName="
				+ resourceName + ", resourceStatus=" + resourceStatus
				+ ", resourceStatusReason=" + resourceStatusReason + ", links="
				+ links + ", time=" + time + ", resourceProperties="
				+ resourceProperties + "}";
	}
}
