package com.woorea.openstack.cinder.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Volume;
import com.woorea.openstack.cinder.model.Volumes;

/**
 * Cinder Volumes Management
 *
 * @author VAL Informatique
 */
public class VolumesResource {

    private final OpenStackClient CLIENT;

    public VolumesResource(OpenStackClient client) {
        this.CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(Volume volume) {
        return new Create(volume);
    }

    public Delete delete(String volumeId) {
        return new Delete(volumeId);
    }

    public Show show(String volumeId) {
        return new Show(volumeId);
    }

    public class List extends OpenStackRequest<Volumes> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/volumes/detail" : "volumes", null, Volumes.class);
        }
    }

    public class Create extends OpenStackRequest<Volume> {

        public Create(Volume volume) {
            super(CLIENT, HttpMethod.POST, "volumes", Entity.json(volume), Volume.class);
        }
    }

    public class Show extends OpenStackRequest<Volume> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("volumes/", id), null, Volume.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, buildPath("volumes/", id), null, Void.class);
        }
    }
    
    
}
