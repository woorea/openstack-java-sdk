package org.openstack.api.compute;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.client.RequestBuilder;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.compute.NovaServerList;

public class ServersResource extends Resource {
	
	public ServersResource(Target target) {
		super(target);
	}

	/**
	 * Returns a list of server names and ids for a given user
	 * 
	 * Returns a list of servers, taking into account any search options specified.
	 * 
	 * If detail is true:
	 * 
	 * Returns a list of server details for a given user
	 * 
	 * @param detail
	 * @return
	 */
	public NovaServerList get(Map<String,Object> properties) {
		if(properties.get("detail") != null) {
			target =  target.path("/detail");
		} 
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(NovaServerList.class);
	}

	public NovaServer post(Map<String,Object> properties, Entity<NovaServerForCreate> serverForCreate) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).post(serverForCreate, NovaServer.class);
	}

	public ServerResource server(String id) {
		return new ServerResource(target.path("/{id}").pathParam("id", id));
	}

	

}
