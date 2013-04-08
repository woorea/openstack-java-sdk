package org.openstack.nova.api.extensions;

import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Snapshot;
import org.openstack.nova.model.SnapshotForCreate;
import org.openstack.nova.model.Snapshots;

public class SnapshotsExtension {

	public static class ListSnapshots implements NovaCommand<Snapshots> {

		boolean detail;

		public ListSnapshots(boolean detail) {
			this.detail = detail;
		}

		public ListSnapshots() {
			this(false);
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path(detail ? "/os-snapshots/detail" : "/os-snapshots");
			request.header("Accept", "application/json");
			request.returnType(Snapshots.class);
			return request;
		}

	}

	public static class CreateSnapshot implements NovaCommand<Snapshot> {

		private SnapshotForCreate snapshotForCreate;

		public CreateSnapshot(SnapshotForCreate snapshotForCreate) {
			this.snapshotForCreate = snapshotForCreate;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/os-snapshots");
			request.header("Accept", "application/json");
			request.json(snapshotForCreate);
			request.returnType(Snapshot.class);
			return request;
		}

	}

	public static class ShowSnapshotMetadata implements
			NovaCommand<Map<String, String>> {

		private String id;

		public ShowSnapshotMetadata(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-snapshots/").path(id).path("metadata");
			request.header("Accept", "application/json");
			request.returnType(Metadata.class);
			return request;
		}

	}

	public static class DeleteSnapshot implements NovaCommand<Void> {

		private String id;

		public DeleteSnapshot(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			// target.path("os-snapshots").path(id).request(MediaType.APPLICATION_JSON).delete();
			return null;
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
