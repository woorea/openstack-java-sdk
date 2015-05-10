package com.woorea.openstack.nova.api;

import java.util.HashMap;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Service;
import com.woorea.openstack.nova.model.Services;


public class ServicesResource {

    private final OpenStackClient CLIENT;

    public ServicesResource(OpenStackClient client) {
        this.CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Enable enable(String host, String binary) {
        return new Enable(host, binary);
    }

    public Disable disable(String host, String binary) {
        return new Disable(host, binary);
    }

    public class List extends OpenStackRequest<Services> {

        public List() {
            super(CLIENT, HttpMethod.GET, "/os-services", null, Services.class);
        }
    }

    public class Enable extends OpenStackRequest<Void> {

        public Enable(final String host, final String binary) {
            super(CLIENT, HttpMethod.PUT, "/os-services/enable", 
            		Entity.json(new HashMap<String, String>() {{ put("host", host); put("binary", binary); }}), Void.class);
        }
    }

    public class Disable extends OpenStackRequest<Void> {

        public Disable(final String host, final String binary) {
            super(CLIENT, HttpMethod.PUT, "/os-services/disable", 
            		Entity.json(new HashMap<String, String>() {{ put("host", host); put("binary", binary); }}), Void.class);
        }
    }

}
