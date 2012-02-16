package org.openstack.client.common;

import java.util.List;

import org.openstack.client.OpenstackCredentials;
import org.openstack.model.identity.ServiceEndpoint;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public class OpenstackClient {
    final OpenstackAuthenticationClient authenticationClient;

    public OpenstackClient(String url, OpenstackCredentials credentials, boolean verbose) {
        ClientConfig config = new DefaultClientConfig();

        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        Client client = Client.create(config);

        if (verbose) {
            client.addFilter(new LoggingFilter(System.out));
        }

        this.authenticationClient = new OpenstackAuthenticationClient(client, url, credentials);
    }

    public OpenstackImageClient getImageClient() {
        return new OpenstackImageClient(authenticationClient);
    }
}
