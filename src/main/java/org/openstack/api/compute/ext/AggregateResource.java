package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.aggregate.Aggregate;
import org.openstack.model.compute.nova.aggregate.AggregateAction;

public class AggregateResource extends Resource {

	public AggregateResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public Aggregate get() {
		return target.request(MediaType.APPLICATION_JSON).get(Aggregate.class);
	}
	
	public Aggregate post(AggregateAction action) {
		//return target.path("/action").request(MediaType.APPLICATION_JSON).post(Entity.entity(action, MediaType.APPLICATION_JSON), Aggregate.class);
		return execute(target.path("/action").request(MediaType.APPLICATION_JSON).buildPost(Entity.entity(action, MediaType.APPLICATION_JSON)), Aggregate.class);
		
	}
	
	public String delete() {
		return target.request(MediaType.APPLICATION_JSON).delete(String.class);
	}
	
}
