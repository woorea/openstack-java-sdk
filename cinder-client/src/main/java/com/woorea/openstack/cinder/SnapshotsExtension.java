package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Metadata;
import com.woorea.openstack.cinder.model.Snapshot;
import com.woorea.openstack.cinder.model.SnapshotForCreate;
import com.woorea.openstack.cinder.model.SnapshotForUpdate;
import com.woorea.openstack.cinder.model.Snapshots;
import com.woorea.openstack.cinder.model.VolumeForUpdate;

public class SnapshotsExtension {

    private final OpenStackClient CLIENT;

    public SnapshotsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(SnapshotForCreate snapshotForCreate) {
        return new Create(snapshotForCreate);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public ShowMetadata showMetadata(String snapshotId) {
        return new ShowMetadata(snapshotId);
    }

    public UpdateMetadata updateMetadata(String snapshotId, Metadata metadata) {
        return new UpdateMetadata(snapshotId, metadata);
    }

    public Delete delete(String id) {
        return new Delete(id);
    }

    public Update update(String id, SnapshotForUpdate snapshot) {
        return new Update(id, snapshot);
    }

    public class List extends OpenStackRequest<Snapshots> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/snapshots/detail" : "/snapshots", null, Snapshots.class);
        }

    }

    public class Create extends OpenStackRequest<Snapshot> {

        public Create(SnapshotForCreate snapshotForCreate) {
            super(CLIENT, HttpMethod.POST, "/snapshots", Entity.json(snapshotForCreate), Snapshot.class);
        }

    }

    public class Show extends OpenStackRequest<Snapshot> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/snapshots/").append(id).toString(), null, Snapshot.class);
        }

    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/snapshots/").append(id).toString(), null, Void.class);
        }

    }

    public class Update extends OpenStackRequest<Void> {

        public Update(String id, SnapshotForUpdate snapshot) {
            super(CLIENT, HttpMethod.PUT, new StringBuilder("/snapshots/").append(id).toString(),
                    Entity.json(snapshot), Void.class);
        }

    }

    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String id) {
            super(CLIENT,
                    HttpMethod.GET,
                    new StringBuilder("/snapshots/").append(id).append("/metadata").toString(),
                    null,
                    Metadata.class);
        }

    }

    public class UpdateMetadata extends OpenStackRequest<Void> {

        public UpdateMetadata(String snapshotId, Metadata metadata) {
            super(CLIENT, HttpMethod.PUT, new StringBuilder("/snapshots/").append(snapshotId)
                    .append("/metadata")
                    .toString(), Entity.json(metadata), Void.class);
        }

    }
}
