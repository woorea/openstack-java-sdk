package com.woorea.openstack.swift.api;

import java.io.InputStream;
import java.util.Map;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.swift.model.ObjectDownload;
import com.woorea.openstack.swift.model.ObjectForUpload;
import com.woorea.openstack.swift.model.Objects;


public class ContainerResource {
    private final OpenStackClient CLIENT;
    private String container;

    public ContainerResource(OpenStackClient client, String container) {
        CLIENT = client;
        this.container = container;
    }

    public List list() {
        return new List(container, null);
    }

    public CreateDirectory createDirectory(String path) {
        return new CreateDirectory(container, path);
    }

    public Show show(String path) {
        return new Show(container, path);
    }

    public Upload upload(ObjectForUpload objectForUpload) {
        return new Upload(objectForUpload);
    }

    public Download download(String path) {
        return new Download(container, path);
    }

    public Delete delete(String path) {
        return new Delete(container, path);
    }

    public class List extends OpenStackRequest<Objects> {
        public List(String containerName, Map<String, String> filters) {
            super(CLIENT, HttpMethod.GET, container + "/", null,
                Objects.class);
        }
    }

    public class CreateDirectory extends OpenStackRequest<Void> {
        public CreateDirectory(String container, String path) {
            super(CLIENT, HttpMethod.PUT, buildPath(container, "/", path),
                Entity.json("*"), null);
        }
    }

    public class Show extends OpenStackRequest<Object> {
        public Show(String containerName, String objectName) {
            super(CLIENT, HttpMethod.GET,
                buildPath(containerName, "/", objectName), Entity.json("*"),
                Object.class);
        }
    }

    public class Upload extends OpenStackRequest<OpenStackResponse> {
        public Upload(ObjectForUpload objectForUpload) {
            super(CLIENT, HttpMethod.PUT,
                buildPath(objectForUpload.getContainer(), "/",
                    objectForUpload.getName()),
                new Entity<InputStream>(objectForUpload.getInputStream(),
                    objectForUpload.getProperties().get("Content-Type")
                                   .toString()), null);

            for (String key : objectForUpload.getProperties().keySet()) {
                header("x-object-meta-" + key,
                    objectForUpload.getProperties().get(key));
            }
        }
    }

    public class Download extends OpenStackRequest<ObjectDownload> {
        public Download(String containerName, String objectName) {
            super(CLIENT, HttpMethod.GET,
                buildPath(containerName, "/", objectName), null,
                ObjectDownload.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {
        public Delete(String containerName, String objectName) {
            super(CLIENT, HttpMethod.DELETE,
                buildPath(containerName, "/", objectName), null, null);
        }
    }
}
