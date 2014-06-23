package com.woorea.openstack.cinder.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Snapshot;
import com.woorea.openstack.cinder.model.SnapshotForCreate;
import com.woorea.openstack.cinder.model.Snapshots;

/**
 * Cinder Snapshots Management
 *
 * @author VAL Informatique
 */
public class SnapshotsResource {

    private final OpenStackClient CLIENT;

    public SnapshotsResource(OpenStackClient client) {
        this.CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(SnapshotForCreate snapshotForCreate) {
        return new Create(snapshotForCreate);
    }

    public Delete delete(String snapshotId) {
        return new Delete(snapshotId);
    }

    public Show show(String snapshotId) {
        return new Show(snapshotId);
    }

    public class List extends OpenStackRequest<Snapshots> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/snapshots/detail" : "snapshots", null, Snapshots.class);
        }
    }

    public class Create extends OpenStackRequest<Snapshot> {

        public Create(SnapshotForCreate snapshotForCreate) {
            super(CLIENT, HttpMethod.POST, "snapshots", Entity.json(snapshotForCreate), Snapshot.class);
        }
    }

    public class Show extends OpenStackRequest<Snapshot> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("snapshots/", id), null, Snapshot.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, buildPath("snapshots/", id), null, Void.class);
        }
    }
}
