package org.openstack.nova.api.extensions;

import java.util.Map;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Snapshot;
import org.openstack.nova.model.SnapshotForCreate;
import org.openstack.nova.model.Snapshots;

public class SnapshotsExtension {
	
	public static class ListSnapshots implements NovaCommand<Snapshots>{

		boolean detail;
		
		public ListSnapshots(boolean detail) {
			this.detail = detail;
		}
		
		public ListSnapshots() {
			this(false);
		}

		@Override
		public Snapshots execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path(detail ? "/os-snapshots/detail" : "/os-snapshots");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Snapshots.class);
		}

	}

	public static class CreateSnapshot implements NovaCommand<Snapshot> {

		private SnapshotForCreate snapshotForCreate;
		
		public CreateSnapshot(SnapshotForCreate snapshotForCreate) {
			this.snapshotForCreate = snapshotForCreate;
		}

		@Override
		public Snapshot execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-snapshots");
		    request.header("Accept", "application/json");
		    request.json(snapshotForCreate);
		    return connector.execute(request, Snapshot.class);
		}
		
	}
	
	public static class ShowSnapshotMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowSnapshotMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-snapshots/").path(id).path("metadata");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Metadata.class).getMetadata();
		}
		
	}


	public static class DeleteSnapshot implements NovaCommand<Void> {

		private String id;
		
		public DeleteSnapshot(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//target.path("os-snapshots").path(id).request(MediaType.APPLICATION_JSON).delete();
			return null;
		}
		
	}
	
	public static ListSnapshots listSnapshots() {
		return new ListSnapshots();
	}
	
	public static CreateSnapshot createSnapshot(SnapshotForCreate snapshotForCreate) {
		return new CreateSnapshot(snapshotForCreate);
	}
	
	public static ShowSnapshotMetadata showSnapshotMetadata(String id) {
		return new ShowSnapshotMetadata(id);
	}
	
	public static DeleteSnapshot deleteSnapshot(String id) {
		return new DeleteSnapshot(id);
	}
}
