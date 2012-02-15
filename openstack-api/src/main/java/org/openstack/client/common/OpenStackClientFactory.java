package org.openstack.client.common;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class OpenStackClientFactory {

    public Client create() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        return client;
    }

    public Client createWithStdoutLogging() {
        Client client = create();
        client.addFilter(new LoggingFilter(System.out));
        return client;
    }

}
