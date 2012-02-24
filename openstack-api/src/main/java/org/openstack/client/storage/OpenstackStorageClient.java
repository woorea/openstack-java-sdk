package org.openstack.client.storage;

import org.openstack.client.common.OpenstackSession;

public class OpenstackStorageClient {

	final OpenstackSession session;
	AccountResource root;

	public OpenstackStorageClient(OpenstackSession session) {
		this.session = session;
		root();
	}

	public synchronized AccountResource root() {
		if (root == null) {
			String endpoint = session.getBestEndpoint("object-store");

			root = new AccountResource(session, endpoint);
		}

		return root;
	}

	public OpenstackSession getSession() {
		return session;
	}

}
