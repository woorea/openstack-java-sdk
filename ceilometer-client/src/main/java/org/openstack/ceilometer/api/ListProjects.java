package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Projects;

public class ListProjects implements CeilometerCommand<Projects> {

	private String source;
	
	public ListProjects(String source) {
		this.source = source;
	}

	@Override
	public Projects execute(WebTarget target) {
		return target.path("source").path("projects").request(MediaType.APPLICATION_JSON).get(Projects.class);
	}

}
