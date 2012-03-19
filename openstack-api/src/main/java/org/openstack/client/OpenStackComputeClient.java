package org.openstack.client;

import org.openstack.api.compute.AsyncServerOperation;
import org.openstack.api.compute.ComputeResource;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.exceptions.OpenstackException;

public class OpenStackComputeClient {

	OpenStackSession session;
	ComputeResource root;

	public OpenStackComputeClient(OpenStackSession session) {
		this.session = session;
		root();
	}

	public synchronized ComputeResource root() throws OpenstackException {
		/*
		if (root == null) {
			String endpoint = session.getData().getBestEndpoint("compute");
			root = new TenantResource(session, endpoint);
		}

		return root;
		*/
		return null;
	}

	public AsyncServerOperation createServer(NovaServerForCreate create) throws OpenstackException {
		//NovaServer server = root().servers().post(create);
		//return AsyncServerOperation.wrapServerCreate(Entity.xml(this), server);
		return null;
	}

	public OpenStackSession getSession() {
		return session;
	}

	public String getRootUrl() {
		return null; //root().resource;
	}
}
