package org.openstack.client.identity;

import org.openstack.client.common.Resource;

public class IdentityResourceBase extends Resource {

	// XML is now supported
	// protected MediaType getDefaultContentType() {
	// // Keystone (Redux) does not yet support XML: Bug #928058
	// return MediaType.APPLICATION_JSON_TYPE;
	// }

	public IdentityResourceBase() {
	}
}
