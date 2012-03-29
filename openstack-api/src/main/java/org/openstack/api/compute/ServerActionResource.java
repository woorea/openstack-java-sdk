package org.openstack.api.compute;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

public class ServerActionResource extends Resource {

	public ServerActionResource(Target target) {
		super(target);
	}
	
	public <T> T post(ServerAction action, Class<T> type) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(action, MediaType.APPLICATION_JSON), type);
	}

}
