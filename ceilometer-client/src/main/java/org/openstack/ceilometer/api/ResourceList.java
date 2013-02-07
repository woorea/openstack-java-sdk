package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Resources;

public class ResourceList implements CeilometerCommand<Resources> {

	private String source;
	
	private String project;
	
	private String user;
	
	public ResourceList source(String source) {
		this.source = source;
		return this;
	}
	
	public ResourceList project(String project) {
		this.project = project;
		return this;
	}
	
	public ResourceList user(String user) {
		this.user = user;
		return this;
	}
	
	@Override
	public Resources execute(WebTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} else if(project != null) {
			target = target.path("projects").path(project);
		} else if(user != null) {
			target = target.path("users").path(user);
		}
		return target.path("v1/resources").request(MediaType.APPLICATION_JSON).get(Resources.class);
	}

}
