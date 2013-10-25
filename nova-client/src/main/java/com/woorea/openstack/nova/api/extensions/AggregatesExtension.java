package com.woorea.openstack.nova.api.extensions;

import java.util.Map;

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
			Map<String, String> metadata) {
		return new UpdateAggregateMetadata(id, metadata);
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

	public class List extends OpenStackRequest<HostAggregates> {

		
		public List() {
			super(CLIENT, HttpMethod.GET, "/os-aggregates", null, HostAggregates.class);
		}

	}

	public class ShowAggregate extends OpenStackRequest<HostAggregate> {

		public ShowAggregate(String id) {
			method(HttpMethod.GET);
			path("/os-aggregates/").path(id);
			header("Accept", "application/json");
			returnType(HostAggregate.class);
		}

	}

	public class UpdateAggregateMetadata extends OpenStackRequest<HostAggregate> {

		private String id;

		private Map<String, String> metadata;

		public UpdateAggregateMetadata(String id, Map<String, String> metadata) {
			this.id = id;
			this.metadata = metadata;
			
			method(HttpMethod.POST);
			path("/os-aggregates/").path(id);
			header("Accept", "application/json");
			json("{\"set_metadata\" : }");
			returnType(HostAggregate.class);
		}

	}

	public class DeleteAggregate extends OpenStackRequest<Void> {

		public DeleteAggregate(String id) {
			method(HttpMethod.DELETE);
			path("/os-aggregates/").path(id);
			header("Accept", "application/json");
		}

	}

	public static class AddHost extends OpenStackRequest<Void> {

		private String aggregateId;

		private String hostId;

		public AddHost(String aggregateId, String hostId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
			// target.path("os-aggregates").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"add_host\" : }"));
		}

	}

	public class RemoveHost extends OpenStackRequest<Void> {

		private String aggregateId;

		private String hostId;

		public RemoveHost(String hostId, String aggregateId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
			// target.path("os-aggregates").path("aggregate").path("os-volume-attachments").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"remove_host\" : }"));

		}

	}

}
