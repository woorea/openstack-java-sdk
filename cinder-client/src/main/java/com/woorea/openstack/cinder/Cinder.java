package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Cinder extends OpenStackClient {

    private final VolumesExtension VOLUMES;

    private final SnapshotsExtension SNAPSHOTS;

    private final VolumeTypesExtension VOLUME_TYPES;

    private final LimitsExtension LIMITS;

    private final SchedulerStatsExtension SCHEDULER_STATS;

    public Cinder(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        VOLUMES = new VolumesExtension(this);
        SNAPSHOTS = new SnapshotsExtension(this);
        VOLUME_TYPES = new VolumeTypesExtension(this);
        LIMITS = new LimitsExtension(this);
        SCHEDULER_STATS = new SchedulerStatsExtension(this);
    }

    public Cinder(String endpoint) {
        this(endpoint, null);
    }

    public final VolumesExtension volumes() {
        return VOLUMES;
    }

    public final SnapshotsExtension snapshots() {
        return SNAPSHOTS;
    }

    public final VolumeTypesExtension volumeTypes() {
        return VOLUME_TYPES;
    }

    public final LimitsExtension limits() {
        return LIMITS;
    }

    public final SchedulerStatsExtension schedulerStats() {
        return SCHEDULER_STATS;
    }
}
