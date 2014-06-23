package com.woorea.openstack.ceilometer.v2.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.ceilometer.v2.model.Resource;

public class ResourcesResource {

    private final OpenStackClient CLIENT;

    public ResourcesResource(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Show show(String id) {
        return new Show(id);
    }

    public class List extends OpenStackRequest<Resource[]> {

        public List() {
            super(CLIENT, HttpMethod.GET, "/ressources", null, Resource[].class);

        }
    }

    public class Show extends OpenStackRequest<Resource> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/ressources/").append(id).toString(), null, Resource.class);
        }
    }
}
