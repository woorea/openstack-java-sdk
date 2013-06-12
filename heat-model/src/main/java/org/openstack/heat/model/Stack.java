package org.openstack.heat.model;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
@JsonRootName("stack")
public class Stack {
	private String id;
	@JsonProperty("stack_name")
	private String name;
	@JsonProperty("creation_time")
	private String createdAt;
	@JsonProperty("updated_time")
	private String updatedAt;
	@JsonProperty("stack_status")
	private String status;
	private List<Link> links;
	@JsonProperty("stack_status_reason")
	private String statusReason;
	private String description;
	
	@JsonProperty("disable_rollback")
	private boolean disableRollback;
	private Map<String,String> parameters;
	private List<Map<String,String>> outputs;
	private List<String> capabilities;
	@JsonProperty("notification_topics")
	private List<String> topics;
	@JsonProperty("timeout_mins")
	private int timeoutInMinute;
	@JsonProperty("template_description")
	private String templateDescription;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	
	public boolean isDisableRollback() {
		return disableRollback;
	}
	public void setDisableRollback(boolean disableRollback) {
		this.disableRollback = disableRollback;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	public List<Map<String, String>> getOutputs() {
		return outputs;
	}
	public void setOutputs(List<Map<String, String>> outputs) {
		this.outputs = outputs;
	}
	public List<String> getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(List<String> capabilities) {
		this.capabilities = capabilities;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	public int getTimeoutInMinute() {
		return timeoutInMinute;
	}
	public void setTimeoutInMinute(int timeoutInMinute) {
		this.timeoutInMinute = timeoutInMinute;
	}
	public String isTemplateDescription() {
		return templateDescription;
	}
	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}
	@Override
	public String toString() {
		return "stack:{id=" + id + ", name=" + name + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", status=" + status
				+ ", links=" + links + ", statusReason=" + statusReason
				+ ", description=" + description + ", disableRollback="
				+ disableRollback + ", parameters=" + parameters + ", outputs="
				+ outputs + ", capabilities=" + capabilities + ", topics="
				+ topics + ", timeoutInMinute=" + timeoutInMinute
				+ ", templateDescription=" + templateDescription + "}";
	}	
}
