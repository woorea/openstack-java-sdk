package org.openstack.client.storage;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.storage.SwiftAccount;

public class AccountResource extends StorageResourceBase {

	public AccountResource(OpenStackSession session, String resource) {
		initialize(session, resource);
	}

	public SwiftAccount show() {
		return resource().get(SwiftAccount.class);
	}

	public ContainersResource containers() {
		return getChildResource("", ContainersResource.class);
	}

	public String getBaseUrl() {
		return resource;
	}

}
