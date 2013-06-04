package com.woorea.openstack.ceilometer.v2.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class Resource {
	//{"resource_id": "23b55841eedd41e99d5f3f32149ca086", "timestamp": "2013-03-03T15:19:00", "project_id": "23b55841eedd41e99d5f3f32149ca086", "user_id": null, "metadata": {}}
	
	@JsonProperty("resource_id")
	private String resource;
	
	private String timestamp;
	
	@JsonProperty("project_id")
	private String project;
	
	@JsonProperty("user_id")
	private String user;
	
	private Map<String, Object> metadata;

	public String getResource() {
		return resource;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getProject() {
		return project;
	}

	public String getUser() {
		return user;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	@Override
	public String toString() {
		return "Resource [resource=" + resource + ", timestamp=" + timestamp
				+ ", project=" + project + ", user=" + user + ", metadata="
				+ metadata + "]";
	}
	
}
