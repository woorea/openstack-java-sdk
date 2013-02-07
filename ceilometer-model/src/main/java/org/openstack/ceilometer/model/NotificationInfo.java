package org.openstack.ceilometer.model;

import java.util.Calendar;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NotificationInfo {
	
	@JsonProperty("event_type")
	private String eventType;
	
	@JsonProperty("_context_project_id")
	private String projectId;
	
	@JsonProperty("_context_user_id")
	private String userId;
	
	@JsonProperty("_context_timestamp")
	private Calendar timestamp;
	
	@JsonProperty("message_id")
	private String messageId;
	
	private Map<String, Object> payload;

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "NotificationInfo [eventType=" + eventType + ", projectId="
				+ projectId + ", userId=" + userId + ", timestamp=" + timestamp
				+ ", messageId=" + messageId + ", payload=" + payload + "]";
	}
	
	

}
