package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.aggregate.Aggregate;
import org.openstack.model.compute.nova.aggregate.AggregateForCreate;
import org.openstack.model.compute.nova.aggregate.AggregateList;

public class AggregatesResource extends Resource {

	public AggregatesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public AggregateList get() {
		return target.request(MediaType.APPLICATION_JSON).get(AggregateList.class);
	}

	public Aggregate post(AggregateForCreate aggregate) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(aggregate, MediaType.APPLICATION_JSON), Aggregate.class);
	}

	public AggregateResource aggregate(String id) {
		return new AggregateResource(target.path("/{aggregateId}").pathParam("aggregateId", id), properties);
	}


}
