package org.openstack.client;

import java.util.Properties;

import org.openstack.client.common.OpenstackSession;

public class OpenstackTestContext {
    public OpenstackSession session;

    public OpenstackSession connect(String url, OpenstackCredentials credentials, boolean verbose) {
    	OpenstackSession session = new OpenstackSession(url, credentials);
        this.session = session;
        if (verbose) {
        	session.setVerbose(true);
        }
        return session;
    }

    public static OpenstackTestContext buildFromProperties() {
        OpenstackTestContext context = new OpenstackTestContext();

        Properties properties = System.getProperties();

        boolean verbose = Boolean.parseBoolean(properties.getProperty("openstack.debug", "false"));

        String url = properties.getProperty("openstack.auth.url", "http://127.0.0.1:5000/v2.0");
        String username = properties.getProperty("openstack.auth.user", "demo");
        String secret = properties.getProperty("openstack.auth.secret", "supersecret");
        String tenant = properties.getProperty("openstack.auth.tenant", "demo");

        OpenstackCredentials credentials = new OpenstackCredentials(username, secret, tenant);
        context.connect(url, credentials, verbose);
        return context;
    }
}
