package org.openstack.api.identity;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneRole;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneServiceList;

public class ServicesResource extends Resource {

	
	public ServicesResource(Target target) {
		super(target);
	}
	
	public Object get() {
		return get(new HashMap<String, Object>());
	}
	
	public KeyStoneServiceList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(KeyStoneServiceList.class);
	}
	
	public KeyStoneService post(Entity<KeyStoneService> user) {
		return target.request(MediaType.APPLICATION_JSON).post(user, KeyStoneService.class);
	}
	
	public ServiceResource service(String id) {
		return new ServiceResource(target.path("/{id}").pathParam("id", id));
	}

	
	
}
