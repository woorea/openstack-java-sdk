package org.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.FloatingIp;
import org.openstack.nova.model.FloatingIps;

public class FloatingIpsExtension {
	
	public static class ListFloatingIps extends OpenStackRequest {

		public ListFloatingIps() {
			method(HttpMethod.GET);
		    path("/os-floating-ips");
		    header("Accept", "application/json");
		    returnType(FloatingIps.class);
		}

	}

	public static class AllocateFloatingIp extends OpenStackRequest {
		
		private Map<String, String> body;
			
		public AllocateFloatingIp(String pool) {
			body = new HashMap<String, String>();
			if(pool != null) {
				body.put("pool", pool);
			}
			method(HttpMethod.POST);
		    path("/os-floating-ips");
		    header("Accept", "application/json");
		    returnType(FloatingIp.class);
		}

	}
	
	public static class DeallocateFloatingIp extends OpenStackRequest {
		
		public DeallocateFloatingIp(String id) {
			method(HttpMethod.DELETE);
		    path("/os-floating-ips/").path(id);
		    header("Accept", "application/json");
		}
		
	}

	
	public static class AssociateFloatingIp extends OpenStackRequest {
		
		private org.openstack.nova.model.ServerAction.AssociateFloatingIp action;

		private String id;
		
		public AssociateFloatingIp(String id, org.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public static class DisassociateFloatingIp extends OpenStackRequest {
		
		private org.openstack.nova.model.ServerAction.DisassociateFloatingIp action;
		
		public DisassociateFloatingIp(String id, org.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public static ListFloatingIps listFloatingIps() {
		return new ListFloatingIps();
	}
	
	public static AllocateFloatingIp allocateFloatingIp(String pool) {
		return new AllocateFloatingIp(pool);
	}
	
	public static DeallocateFloatingIp deallocateFloatingIp(String id) {
		return new DeallocateFloatingIp(id);
	}
	
	public static AssociateFloatingIp associateFloatingIp(String serverId, String floatingIpAddress) {
		org.openstack.nova.model.ServerAction.AssociateFloatingIp action = new org.openstack.nova.model.ServerAction.AssociateFloatingIp(floatingIpAddress);
		return new AssociateFloatingIp(serverId, action);
	}
	
	public static DisassociateFloatingIp disassociateFloatingIp(String serverId, String floatingIpAddress) {
		org.openstack.nova.model.ServerAction.DisassociateFloatingIp action = new org.openstack.nova.model.ServerAction.DisassociateFloatingIp(floatingIpAddress);
		return new DisassociateFloatingIp(serverId, action);
	}
	
}
