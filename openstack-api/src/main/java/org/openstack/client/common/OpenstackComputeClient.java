package org.openstack.client.common;

import org.openstack.client.compute.AsyncServerOperation;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.exceptions.OpenstackException;

public class OpenstackComputeClient {

	OpenStackSession session;
	TenantResource root;

	public OpenstackComputeClient(OpenStackSession session) {
		this.session = session;
		root();
	}

	public synchronized TenantResource root() throws OpenstackException {
		if (root == null) {
			String endpoint = session.getData().getBestEndpoint("compute");
			root = new TenantResource(session, endpoint);
		}

		return root;
	}

	public AsyncServerOperation createServer(NovaServerForCreate create) throws OpenstackException {
		NovaServer server = root().servers().create(create);
		return AsyncServerOperation.wrapServerCreate(this, server);
	}

	public OpenStackSession getSession() {
		return session;
	}

	public String getRootUrl() {
		return root().resource;
	}
}
