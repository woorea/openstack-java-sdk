package com.woorea.openstack.ceilometer.v2.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class Sample {

	@JsonProperty("counter_type")
	private String counterType;

	@JsonProperty("counter_name")
	private String counterName;
	
	@JsonProperty("counter_unit")
	private String counterUnit;
	
	@JsonProperty("counter_volume")
	private String counterVolume;
	
	private String source;
	
	@JsonProperty("project_id")
	private String project;
	
	@JsonProperty("user_id")
	private String user;
	
	@JsonProperty("resource_id")
	private String resource;
	
	private String timestamp;
	
	@JsonProperty("message_id")
	private String message;
	
	@JsonProperty("resource_metadata")
	private Map<String, Object> metadata;

	public String getCounterType() {
		return counterType;
	}

	public String getCounterName() {
		return counterName;
	}

	public String getCounterUnit() {
		return counterUnit;
	}

	public String getCounterVolume() {
		return counterVolume;
	}

	public String getSource() {
		return source;
	}

	public String getProject() {
		return project;
	}

	public String getUser() {
		return user;
	}

	public String getResource() {
		return resource;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	@Override
	public String toString() {
		return "Sample [counterType=" + counterType + ", counterName="
				+ counterName + ", counterUnit=" + counterUnit
				+ ", counterVolume=" + counterVolume + ", source=" + source
				+ ", project=" + project + ", user=" + user + ", resource="
				+ resource + ", timestamp=" + timestamp + ", message="
				+ message + ", metadata=" + metadata + "]";
	}
	
}
