package org.openstack.nova.api.extensions;

import java.util.Map;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.HostAggregate;
import org.openstack.nova.model.HostAggregates;

public class AggregatesExtension {

	public class ListAggregates implements NovaCommand<HostAggregates>{

		@Override
		public HostAggregates execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-aggregates");
		    request.header("Accept", "application/json");
		    return connector.execute(request, HostAggregates.class);			
		}

	}
	
	public class ShowAggregate implements NovaCommand<HostAggregate> {

		private String id;
		
		public ShowAggregate(String id) {
			this.id = id;
		}

		@Override
		public HostAggregate execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-aggregates/").path(id);
		    request.header("Accept", "application/json");
		    return connector.execute(request, HostAggregate.class);
		}
		
	}

	
	public class UpdateAggregateMetadata implements NovaCommand<Void> {
		
		private String id;
		
		private Map<String, String> metadata;
		
		public UpdateAggregateMetadata(String id, Map<String, String> metadata) {
			this.id = id;
			this.metadata = metadata;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-aggregates/").path(id);
		    request.header("Accept", "application/json");
		    request.json("{\"set_metadata\" : }");
		    connector.execute(request, HostAggregate.class);
			return null;
		}

	}
	
	public class DeleteAggregate implements NovaCommand<Void> {

		private String id;
		
		public DeleteAggregate(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("DELETE");
		    request.path("/os-aggregates/").path(id);
		    request.header("Accept", "application/json");
		    connector.execute(request);
			return null;
		}
		
	}

	
	
	public static class AddHost implements NovaCommand<Void> {
		
		private String aggregateId;
		
		private String hostId;
		
		public AddHost(String aggregateId, String hostId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//target.path("os-aggregates").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"add_host\" : }"));
			return null;
		}

	}
	
	public class RemoveHost implements NovaCommand<Void> {
		
		private String aggregateId;
		
		private String hostId;
		
		public RemoveHost(String hostId, String aggregateId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
			
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//target.path("os-aggregates").path("aggregate").path("os-volume-attachments").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"remove_host\" : }"));
			return null;
		}

	}
	
	public ListAggregates listAggregates() {
		return new ListAggregates();
	}
	
	public ShowAggregate showAggregate(String id) {
		return new ShowAggregate(id);
	}
	
	public UpdateAggregateMetadata updateAggregateMetadata(String id, Map<String, String> metadata) {
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
