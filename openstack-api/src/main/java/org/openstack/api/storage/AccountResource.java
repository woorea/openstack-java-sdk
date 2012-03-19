package org.openstack.api.storage;

import org.openstack.api.common.OpenStackSession;
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
