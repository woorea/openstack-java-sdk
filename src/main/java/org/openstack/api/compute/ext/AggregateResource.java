package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.aggregate.AggregateAction;

public class AggregateResource extends Resource {

	protected AggregateResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public String post(AggregateAction action) {
		return null;
	}
	
}
