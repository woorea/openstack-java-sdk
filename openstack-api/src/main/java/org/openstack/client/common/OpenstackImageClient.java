package org.openstack.client.common;

import org.openstack.client.imagestore.GlanceRootResource;

public class OpenstackImageClient {
	
	final OpenstackSession session;
	GlanceRootResource root;

    public OpenstackImageClient(OpenstackSession session) {
    	this.session = session;
        root();
    }

    public synchronized GlanceRootResource root() {
        if (root == null) {
            String endpoint = session.getBestEndpoint("image");

            root = new GlanceRootResource(session, endpoint);
        }

        return root;
    }

	public OpenstackSession getSession() {
		return session;
	}

}
