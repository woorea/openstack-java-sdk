package org.openstack.ceilometer.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.ceilometer.CeilometerCommand;

public class ProjectList implements CeilometerCommand<List<String>> {
	
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
	public List<String> execute(WebTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} 
		return target.path("v1/projects").request(MediaType.APPLICATION_JSON).get(Projects.class).projects;
	}

}
