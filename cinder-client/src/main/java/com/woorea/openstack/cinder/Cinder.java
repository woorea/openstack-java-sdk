package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.cinder.api.BackupsResource;
import com.woorea.openstack.cinder.api.SnapshotsResource;
import com.woorea.openstack.cinder.api.VolumesResource;

/**
 * OpenStack Cinder Client 
 * 
 * Reference:
 * http://api.openstack.org/api-ref-blockstorage.html
 *
 * @author VAL Informatique
 */
public class Cinder extends OpenStackClient {

    private final VolumesResource volumes;
    private final SnapshotsResource snapshots;
    private final BackupsResource backups;

    public Cinder(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        volumes = new VolumesResource(this);
        snapshots = new SnapshotsResource(this);
        backups = new BackupsResource(this);
    }

    public Cinder(String endpoint) {
        this(endpoint, null);
    }

    public VolumesResource volumes() {
        return volumes;
    }

    public SnapshotsResource snapshots() {
        return snapshots;
    }

    public BackupsResource backups() {
        return backups;
    }
}
