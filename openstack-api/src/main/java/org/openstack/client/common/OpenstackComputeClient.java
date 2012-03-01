package org.openstack.client.common;

import org.openstack.client.OpenstackException;
import org.openstack.client.compute.AsyncServerOperation;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;

public class OpenstackComputeClient {

	OpenstackSession session;
	TenantResource root;

	public OpenstackComputeClient(OpenstackSession session) {
		this.session = session;
		root();
	}

	public synchronized TenantResource root() throws OpenstackException {
		if (root == null) {
			String endpoint = session.getBestEndpoint("compute");
			root = new TenantResource(session, endpoint);
		}

		return root;
	}

	public AsyncServerOperation createServer(ServerForCreate create) throws OpenstackException {
		Server server = root().servers().create(create);
		return AsyncServerOperation.wrapServerCreate(this, server);
	}

	public OpenstackSession getSession() {
		return session;
	}

	public String getRootUrl() {
		return root().resource;
	}
}
