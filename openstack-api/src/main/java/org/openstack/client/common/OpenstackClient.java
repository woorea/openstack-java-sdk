package org.openstack.client.common;

import org.openstack.client.OpenstackCredentials;
import org.openstack.client.OpenstackException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public class OpenstackClient {
    final OpenstackAuthenticationClient authenticationClient;

    Client buildClient(boolean verbose) {
        ClientConfig config = new DefaultClientConfig();

        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        Client client = Client.create(config);

        if (verbose) {
            client.addFilter(new LoggingFilter(System.out));
        }

        return client;
    }

    public OpenstackClient(String url, OpenstackCredentials credentials, boolean verbose) {
        Client client = buildClient(verbose);

        this.authenticationClient = new OpenstackAuthenticationClient(client, url, credentials);
    }

    public OpenstackImageClient getImageClient() throws OpenstackException {
        return new OpenstackImageClient(authenticationClient);
    }

    public OpenstackComputeClient getComputeClient() throws OpenstackException {
        return new OpenstackComputeClient(authenticationClient);
    }

    public OpenstackAuthenticationClient getAuthenticationClient() {
        return authenticationClient;
    }
}
