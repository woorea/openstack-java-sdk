package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Snapshot;
import org.openstack.nova.model.SnapshotForCreate;
import org.openstack.nova.model.Snapshots;

public class SnapshotsExtension {

	public static class ListSnapshots extends OpenStackRequest {

		boolean detail;

		public ListSnapshots(boolean detail) {
			method(HttpMethod.GET);
			path(detail ? "/os-snapshots/detail" : "/os-snapshots");
			header("Accept", "application/json");
			returnType(Snapshots.class);
		}

		public ListSnapshots() {
			this(false);
		}

	}

	public static class CreateSnapshot extends OpenStackRequest {

		private SnapshotForCreate snapshotForCreate;

		public CreateSnapshot(SnapshotForCreate snapshotForCreate) {
			this.snapshotForCreate = snapshotForCreate;
			method(HttpMethod.POST);
			path("/os-snapshots");
			header("Accept", "application/json");
			json(snapshotForCreate);
			returnType(Snapshot.class);
		}
		
	}

	public static class ShowSnapshotMetadata extends OpenStackRequest {

		public ShowSnapshotMetadata(String id) {
			method(HttpMethod.GET);
			path("/os-snapshots/").path(id).path("metadata");
			header("Accept", "application/json");
			returnType(Metadata.class);
		}

	}

	public static class DeleteSnapshot extends OpenStackRequest {

		public DeleteSnapshot(String id) {
			// target.path("os-snapshots").path(id).request(MediaType.APPLICATION_JSON).delete();
		}

	}

	public static ListSnapshots listSnapshots() {
		return new ListSnapshots();
	}

	public static CreateSnapshot createSnapshot(
			SnapshotForCreate snapshotForCreate) {
		return new CreateSnapshot(snapshotForCreate);
	}

	public static ShowSnapshotMetadata showSnapshotMetadata(String id) {
		return new ShowSnapshotMetadata(id);
	}

	public static DeleteSnapshot deleteSnapshot(String id) {
		return new DeleteSnapshot(id);
	}
}
