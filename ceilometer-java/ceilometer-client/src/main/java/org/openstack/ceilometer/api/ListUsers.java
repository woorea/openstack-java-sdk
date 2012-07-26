package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Users;

public class ListUsers implements CeilometerCommand<Users> {

	private String source;
	
	public ListUsers(String source) {
		this.source = source;
	}

	@Override
	public Users execute(WebTarget target) {
		return target.path("source").path("users").request(MediaType.APPLICATION_JSON).get(Users.class);
	}

}
