package com.woorea.openstack.ceilometer.v2.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.ceilometer.v2.model.Meter;
import com.woorea.openstack.ceilometer.v2.model.Sample;

public class MetersResource {

    private final OpenStackClient CLIENT;

    public MetersResource(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Show show(String name) {
        return new Show(name);
    }

    public class List extends OpenStackRequest<Meter[]> {

        public List() {
            super(CLIENT, HttpMethod.GET, "/meters", null, Meter[].class);
        }
    }

    public class Show extends OpenStackRequest<Sample[]> {

        public Show(String name) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/meters/").append(name).toString(), null, Sample[].class);
        }
    }
}