package org.openstack.model.compute.nova.floatingipdns;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("domain_entry")
public class DomainEntry {

	private String scope;
	
	@JsonProperty("project")
	private String project;
	
	@JsonProperty("availability_zone")
	private String availabilityZone;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}
	
}
