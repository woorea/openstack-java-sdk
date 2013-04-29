package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.FloatingIpPools;

public class FloatingIpPoolsExtension {

	public static class ListFloatingIpPools extends OpenStackRequest {

		public ListFloatingIpPools() {
			method(HttpMethod.GET);
			path("/os-floating-ip-pools/");
			header("Accept", "application/json");
			returnType(FloatingIpPools.class);

		}

	}

	public static ListFloatingIpPools listFloatingIpPools() {
		return new ListFloatingIpPools();
	}

}
