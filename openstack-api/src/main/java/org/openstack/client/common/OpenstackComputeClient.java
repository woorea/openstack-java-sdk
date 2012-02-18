package org.openstack.client.common;

import org.openstack.client.OpenstackException;
import org.openstack.client.compute.AsyncServerOperation;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;

import com.google.common.collect.Lists;

public class OpenstackComputeClient {
    private final OpenstackAuthenticationClient authClient;

    public OpenstackComputeClient(OpenstackAuthenticationClient authClient) throws OpenstackException {
        this.authClient = authClient;

        root();
    }

    TenantResource root;

    public synchronized TenantResource root() throws OpenstackException {
        if (root == null) {
            String endpoint = authClient.getBestEndpoint("compute");

            root = new TenantResource(authClient.getClient(), endpoint);
        }

        return root;
    }

    public AsyncServerOperation createServer(ServerForCreate create) throws OpenstackException {
        Server server = root().servers().create(create);
        return new AsyncServerOperation(this, server, server.getId(), Lists.newArrayList("BUILD"), Lists.newArrayList("ACTIVE"));
    }
}
