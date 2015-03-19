package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Pools;

/**
 * Cinder Scheduler Stats Management
 *
 * @author Ahmed Saba
 */
public class SchedulerStatsExtension {

    private final OpenStackClient CLIENT;

    public SchedulerStatsExtension(OpenStackClient client) {
        this.CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public class List extends OpenStackRequest<Pools> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, "/scheduler-stats/get_pools" + (detail ? "?detail=True" : ""), null, Pools.class);
        }
    }

}
