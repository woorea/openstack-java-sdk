package org.openstack.api.compute;

import java.util.Map;
import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.nova.NovaServer;
import org.openstack.model.compute.nova.NovaServerList;

public class ServersResource extends Resource {
	
	public ServersResource(Target target, Properties properties) {
		super(target, properties);
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
	public ServerList get(Map<String, Object> filters) {
		Target target = this.target.path("/detail");
		if(filters != null) {
			if(filters.get("all_tenants") != null) {
				target = target.queryParam("all_tenants", filters.get("all_tenants"));
			}
			if(filters.get("image") != null) {
				target = target.queryParam("image", filters.get("image"));
			}
			if(filters.get("flavor") != null) {
				target = target.queryParam("flavor", filters.get("flavor"));
			}
			if(filters.get("name") != null) {
				target = target.queryParam("name", filters.get("name"));
			}
			if(filters.get("status") != null) {
				target = target.queryParam("status", filters.get("status"));
			}
			if(filters.get("marker") != null) {
				target = target.queryParam("marker", filters.get("marker"));
			}
			if(filters.get("limit") != null) {
				target = target.queryParam("limit", filters.get("marker"));
			}
			if(filters.get("changes-since") != null) {
				target = target.queryParam("changes-since", filters.get("changes-since"));
			}
			if(filters.get("deleted") != null) {
				target = target.queryParam("deleted", filters.get("deleted"));
			}
		}
		return target.request(MediaType.APPLICATION_JSON).get(NovaServerList.class);
	}

	
	public ServerList get() {
		return get(null);
	}

	public Server post(ServerForCreate serverForCreate) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(serverForCreate, MediaType.APPLICATION_JSON), NovaServer.class);
	}

	public ServerResource server(String id) {
		return new ServerResource(target.path("/{id}").pathParam("id", id), properties);
	}

	

	

	

}
