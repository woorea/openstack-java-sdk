package org.openstack.ceilometer.api;

public class EventFilter {
	
	private String user;
	
	private String project;
	
	private Long start;
	
	private Long end;
	
	private String resource;

	private String meter;
	
	private String source;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getMeter() {
		return meter;
	}

	public void setMeter(String meter) {
		this.meter = meter;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}
