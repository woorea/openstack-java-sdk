package org.openstack.nova.api.extensions;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		public Snapshots execute(WebTarget target) {
			String path = detail ? "os-snapshots/detail" : "os-snapshots";
			return target.path(path).request(MediaType.APPLICATION_JSON).get(Snapshots.class);
		}

	}

	public static class CreateSnapshot implements NovaCommand<Snapshot> {

		private SnapshotForCreate snapshotForCreate;
		
		public CreateSnapshot(SnapshotForCreate snapshotForCreate) {
			this.snapshotForCreate = snapshotForCreate;
		}

		@Override
		public Snapshot execute(WebTarget target) {
			return target.path("os-snapshots").request(MediaType.APPLICATION_JSON).post(Entity.json(snapshotForCreate), Snapshot.class);
		}
		
	}
	
	public static class ShowSnapshotMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowSnapshotMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(WebTarget target) {
			Metadata metadata = target.path("os-snapshots").path(id).path("metadata").request(MediaType.APPLICATION_JSON).get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}


	public static class DeleteSnapshot implements NovaCommand<Void> {

		private String id;
		
		public DeleteSnapshot(String id) {
			this.id = id;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("os-snapshots").path(id).request(MediaType.APPLICATION_JSON).delete();
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
