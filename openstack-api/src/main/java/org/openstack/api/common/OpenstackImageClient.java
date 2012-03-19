package org.openstack.api.common;

import org.openstack.api.imagestore.GlanceRootResource;

public class OpenstackImageClient {
	
	final OpenStackSession session;
	GlanceRootResource root;

    public OpenstackImageClient(OpenStackSession session) {
    	this.session = session;
        root();
    }

    public synchronized GlanceRootResource root() {
        if (root == null) {
            String endpoint = session.getData().getBestEndpoint("image");

            root = new GlanceRootResource(session, endpoint);
        }

        return root;
    }

	public OpenStackSession getSession() {
		return session;
	}

}
