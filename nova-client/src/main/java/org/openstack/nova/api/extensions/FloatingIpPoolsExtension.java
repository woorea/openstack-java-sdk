package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.FloatingIpPools;

public class FloatingIpPoolsExtension {

	public static class ListFloatingIpPools implements NovaCommand<FloatingIpPools>{

		@Override
		public FloatingIpPools execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-floating-ip-pools/");
		    request.header("Accept", "application/json");
		    return connector.execute(request, FloatingIpPools.class);
		}

	}
	
	public static ListFloatingIpPools listFloatingIpPools() {
		return new ListFloatingIpPools();
	}
	
}
