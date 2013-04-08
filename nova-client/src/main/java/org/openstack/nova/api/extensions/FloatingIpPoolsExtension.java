package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.FloatingIpPools;

public class FloatingIpPoolsExtension {

	public static class ListFloatingIpPools implements NovaCommand<FloatingIpPools>{

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-floating-ip-pools/");
		    request.header("Accept", "application/json");
		    request.returnType(FloatingIpPools.class);
		return request;
		}

	}
	
	public static ListFloatingIpPools listFloatingIpPools() {
		return new ListFloatingIpPools();
	}
	
}
