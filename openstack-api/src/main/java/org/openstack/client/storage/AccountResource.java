package org.openstack.client.storage;

import org.openstack.client.common.OpenstackSession;
import org.openstack.model.storage.Account;

public class AccountResource extends StorageResourceBase {

	public AccountResource(OpenstackSession session, String resource) {
		initialize(session, resource);
	}

	public Account show() {
		return resource().get(Account.class);
	}

	public ContainersResource containers() {
		return getChildResource("", ContainersResource.class);
	}

	public String getBaseUrl() {
		return resource;
	}

}
