package com.woorea.openstack.swift.api;

import java.util.HashMap;
import java.util.Map;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.swift.model.Container;
import com.woorea.openstack.swift.model.Containers;


public class ContainersResource {
    private final OpenStackClient CLIENT;

    public ContainersResource(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Create create(String name) {
        return new Create(name, null);
    }

    public Create create(String name, boolean isPublic) {
        Map<String, String> props = new HashMap<String, String>();

        if (isPublic) {
            props.put("X-Container-Read", ".r:*,.rlistings");
            props.put("X-Container-Write", "*");
        }

        return create(name, props);
    }

    public Create create(String name, Map<String, String> props) {
        return new Create(name, props);
    }

    public Update update(String name, boolean isPublic) {
        Map<String, String> props = new HashMap<String, String>();

        if (isPublic) {
            props.put("X-Container-Read", ".r:*,.rlistings");
            props.put("X-Container-Write", "*");
        }

        return update(name, props);
    }

    public Update update(String name, Map<String, String> props) {
        return new Update(name, props);
    }

    public Show show(String name) {
        return new Show(name);
    }

    public Delete delete(String name) {
        return new Delete(name);
    }

    public ContainerResource container(String name) {
        return new ContainerResource(CLIENT, name);
    }

    public class List extends OpenStackRequest<Containers> {
        public List() {
            super(CLIENT, HttpMethod.GET, "/", null, Containers.class);

            //return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
        }
    }

    public class Create extends OpenStackRequest<Container> {
        public Create(String containerName, Map<String, String> properties) {
            super(CLIENT, HttpMethod.PUT, buildPath(containerName),
                Entity.json("*"), null);

            if (properties != null) {
                for (String key : properties.keySet()) {
                    header(key, properties.get(key));
                }
            }
        }
    }

    public class Update extends OpenStackRequest<Container> {
        public Update(String containerName, Map<String, String> properties) {
            super(CLIENT, HttpMethod.POST, buildPath(containerName),
                Entity.json("*"), null);

            if (properties != null) {
                for (String key : properties.keySet()) {
                    header(key, properties.get(key));
                }
            }
        }
    }

    public class Show extends OpenStackRequest<Container> {
        public Show(String containerName) {
            super(CLIENT, HttpMethod.GET, buildPath(containerName),
                Entity.json("*"), Container.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {
        public Delete(String containerName) {
            super(CLIENT, HttpMethod.DELETE, buildPath(containerName), null,
                null);
        }
    }
}
