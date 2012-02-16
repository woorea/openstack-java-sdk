package org.openstack.client;

import java.util.Properties;

import org.openstack.client.common.OpenstackClient;

public class OpenstackTestContext {
    public OpenstackClient client;

    public OpenstackClient connect(String url, OpenstackCredentials credentials, boolean verbose) {
        OpenstackClient client = new OpenstackClient(url, credentials, verbose);
        this.client = client;
        return client;
    }

    public static OpenstackTestContext buildFromProperties() {
        OpenstackTestContext context = new OpenstackTestContext();

        boolean verbose = false;

        Properties properties = System.getProperties();
        String url = properties.getProperty("openstack.auth.url", "http://127.0.0.1:5000/v2.0");
        String username = properties.getProperty("openstack.auth.user", "demo");
        String secret = properties.getProperty("openstack.auth.secret", "supersecret");
        String tenant = properties.getProperty("openstack.auth.tenant", "demo");

        OpenstackCredentials credentials = new OpenstackCredentials(username, secret, tenant);
        context.connect(url, credentials, verbose);
        return context;
    }
}
