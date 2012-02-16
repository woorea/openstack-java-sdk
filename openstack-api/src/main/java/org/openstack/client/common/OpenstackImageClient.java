package org.openstack.client.common;

import org.openstack.client.OpenstackException;
import org.openstack.client.imagestore.GlanceRootResource;

public class OpenstackImageClient {
    private final OpenstackAuthenticationClient authClient;

    public OpenstackImageClient(OpenstackAuthenticationClient authClient) {
        this.authClient = authClient;
    }

    GlanceRootResource root;

    public synchronized GlanceRootResource root() throws OpenstackException {
        if (root == null) {
            String endpoint = authClient.getBestEndpoint("image");

            root = new GlanceRootResource(authClient.getClient(), endpoint);
        }

        return root;
    }
}
