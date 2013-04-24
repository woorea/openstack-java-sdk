package org.openstack.nova.api.extensions;

import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.HostAggregate;
import org.openstack.nova.model.HostAggregates;

public class AggregatesExtension {

	public class ListAggregates implements OpenStackCommand<HostAggregates> {

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
			OpenStackRequest request = new OpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-aggregates");
			request.header("Accept", "application/json");
			request.returnType(HostAggregates.class);
			return request;
		}

	}

	public class ShowAggregate implements OpenStackCommand<HostAggregate> {

		private String id;

		public ShowAggregate(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
			OpenStackRequest request = new OpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-aggregates/").path(id);
			request.header("Accept", "application/json");
			request.returnType(HostAggregate.class);
			return request;
		}

	}

	public class UpdateAggregateMetadata implements OpenStackCommand<Void> {

		private String id;

		private Map<String, String> metadata;

		public UpdateAggregateMetadata(String id, Map<String, String> metadata) {
			this.id = id;
			this.metadata = metadata;
		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
			OpenStackRequest request = new OpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/os-aggregates/").path(id);
			request.header("Accept", "application/json");
			request.json("{\"set_metadata\" : }");
			request.returnType(HostAggregate.class);
			return null;
		}

	}

	public class DeleteAggregate implements OpenStackCommand<Void> {

		private String id;

		public DeleteAggregate(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
			OpenStackRequest request = new OpenStackRequest();
			request.method(HttpMethod.DELETE);
			request.path("/os-aggregates/").path(id);
			request.header("Accept", "application/json");
			return request;
		}

	}

	public static class AddHost implements OpenStackCommand<Void> {

		private String aggregateId;

		private String hostId;

		public AddHost(String aggregateId, String hostId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
			// target.path("os-aggregates").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"add_host\" : }"));
			return null;
		}

	}

	public class RemoveHost implements OpenStackCommand<Void> {

		private String aggregateId;

		private String hostId;

		public RemoveHost(String hostId, String aggregateId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;

		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
			// target.path("os-aggregates").path("aggregate").path("os-volume-attachments").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"remove_host\" : }"));
			return null;
		}

	}

	public ListAggregates listAggregates() {
		return new ListAggregates();
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

}
