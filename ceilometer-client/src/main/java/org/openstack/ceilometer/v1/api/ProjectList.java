package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class ProjectList implements OpenStackCommand<List<String>> {
	
	private static final class Projects {
		
		@JsonProperty
		private List<String> projects;
		
	}

	private String source;
	
	public ProjectList source(String source) {
		this.source = source;
		return this;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		return null;
		//if(source != null) {
		//	target = target.path("sources").path(source);
		//} 
		//return target.path("v1/projects").request(MediaType.APPLICATION_JSON).get(Projects.class).projects;
	}

}
