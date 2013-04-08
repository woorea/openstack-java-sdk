package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
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
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		return null;
		//if(source != null) {
		//	target = target.path("sources").path(source);
		//} 
		//return target.path("v1/projects").request(MediaType.APPLICATION_JSON).get(Projects.class).projects;
	}

}
