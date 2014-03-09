package com.woorea.openstack.heat;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.heat.model.Resources;


/**
 * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
 */
public class ResourcesResource {
    private final OpenStackClient client;

    public ResourcesResource(OpenStackClient client) {
        this.client = client;
    }

    public ListResources listResources(String name) {
        return new ListResources(name);
    }

    /**
     * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
     */
    public class ListResources extends OpenStackRequest<Resources> {
        public ListResources(String name) {
            super(client, HttpMethod.GET, "/stacks/" + name + "/resources", null, Resources.class);
        }
    }
}
