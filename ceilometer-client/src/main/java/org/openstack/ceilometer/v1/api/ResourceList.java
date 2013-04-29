package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v1.model.Resources;

public class ResourceList implements OpenStackCommand<Resources> {

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
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
//		if(source != null) {
//			target = target.path("sources").path(source);
//		} else if(project != null) {
//			target = target.path("projects").path(project);
//		} else if(user != null) {
//			target = target.path("users").path(user);
//		}
//		return target.path("resources").request(MediaType.APPLICATION_JSON).get(Resources.class);
		return null;
	}

}
