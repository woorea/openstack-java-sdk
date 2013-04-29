package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.base.client.OpenStackRequest;

public class UserList extends OpenStackRequest {
	
	private static final class Users {
		
		@JsonProperty
		private List<String> users;
		
	}

	private String source;
	
	public UserList() {
//		if(source != null) {
//			target = target.path("/sources").path(source);
//		}
//		return target.path("v1/users").request(MediaType.APPLICATION_JSON).get(Users.class).users;
	}
	
	public UserList source(String source) {
		this.source = source;
		return this;
	}


	
	
}
