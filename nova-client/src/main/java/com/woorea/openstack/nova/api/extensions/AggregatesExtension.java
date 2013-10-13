package com.woorea.openstack.nova.api.extensions;

import java.util.Map;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.HostAggregate;
import com.woorea.openstack.nova.model.HostAggregates;

public class AggregatesExtension {
	
	private final OpenStackClient CLIENT;
	
	public AggregatesExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}

	public ShowAggregate showAggregate(String id) {
		return new ShowAggregate(id);
	}

	public UpdateAggregateMetadata updateAggregateMetadata(String id,
			String name, String availabilityZone) {
		return new UpdateAggregateMetadata(id, name, availabilityZone);
	}

	public CreateAggregate createAggregate(String aggregateName,
										   String availabilityZoneName) {
		return new CreateAggregate(aggregateName, availabilityZoneName);
	}

	public DeleteAggregate deleteAggregate(String id) {
		return new DeleteAggregate(id);
	}

	public AddHost addHost(String aggregateId, String hostId) {
		return new AddHost(aggregateId, hostId);
	}

	public RemoveHost removeHost(String aggregateId, String hostId) {
		return new RemoveHost(hostId, aggregateId);
	}

	public SetMetadata setMetadata(String aggregateId,
								   String key, String value) {
		return new SetMetadata(aggregateId, key, value);
	}

	public class List extends OpenStackRequest<HostAggregates> {
		
		public List() {
			super(CLIENT, HttpMethod.GET, "/os-aggregates",
				  null,
				  HostAggregates.class);
		}

	}

	public class ShowAggregate extends OpenStackRequest<HostAggregate> {

		public ShowAggregate(String id) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/os-aggregates/").append(id),
				  null,
				  HostAggregate.class);
		}

	}

	public class UpdateAggregateMetadata extends OpenStackRequest<HostAggregate> {
		public UpdateAggregateMetadata(String id,
									   String name, String availabilityZone) {
			super(CLIENT, HttpMethod.PUT,
				  new StringBuffer("/os-aggregates/").append(id),
				  availabilityZone == null ?
				  Entity.json("{\"aggregate\": {\"name\": \"" + name + "\" }}")
				  :
				  Entity.json("{\"aggregate\": {\"name\": \"" +
							  name +
							  "\", \"availability_zone\": \"" +
							  availabilityZone +
							  "\" }}"),
				  HostAggregate.class);
		}

	}

	public class CreateAggregate extends OpenStackRequest<HostAggregate> {

		public CreateAggregate(String name, String availabilityZone) {
			super(CLIENT, HttpMethod.POST,
				  new StringBuffer("/os-aggregates"),
				  availabilityZone == null ?
				  Entity.json("{\"aggregate\": {\"name\": \"" +
							  name +
							  "\", \"availability_zone\": null }}")
				  :
				  Entity.json("{\"aggregate\": {\"name\": \"" +
							  name +
							  "\", \"availability_zone\": \"" +
							  availabilityZone +
							  "\" }}"),
				  HostAggregate.class);
		}

	}

	public class DeleteAggregate extends OpenStackRequest<Void> {

		public DeleteAggregate(String id) {
			super(CLIENT, HttpMethod.DELETE,
				  new StringBuffer("/os-aggregates/").append(id),
				  null,
				  null);
		}
	}

	public class AddHost extends OpenStackRequest<HostAggregate> {

		public AddHost(String aggregateId, String hostId) {
			super(CLIENT, HttpMethod.POST,
				  new StringBuffer("/os-aggregates/")
				  .append(aggregateId).append("/action"),
				  Entity.json("{\"add_host\": {\"host\": \"" +
							  hostId + "\" }}"),
				  HostAggregate.class);
		}

	}

	public class RemoveHost extends OpenStackRequest<HostAggregate> {

		public RemoveHost(String hostId, String aggregateId) {
			super(CLIENT, HttpMethod.POST,
				  new StringBuffer("/os-aggregates/")
				  .append(aggregateId).append("/action"),
				  Entity.json("{\"remove_host\": {\"host\": \"" +
							  hostId + "\" }}"),
				  HostAggregate.class);
		}

	}

	public class SetMetadata extends OpenStackRequest<HostAggregate> {

		public SetMetadata(String aggregateId, String key, String value) {
			super(CLIENT, HttpMethod.POST,
				  new StringBuffer("/os-aggregates/")
				  .append(aggregateId).append("/action"),
				  Entity.json("{\"set_metadata\": {\"metadata\": { \"" +
							  key + "\": \"" + value + "\" }}}"),
				  HostAggregate.class);
		}
	}
}

