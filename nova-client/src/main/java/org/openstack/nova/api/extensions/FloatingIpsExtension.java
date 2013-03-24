package org.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.FloatingIp;
import org.openstack.nova.model.FloatingIps;

public class FloatingIpsExtension {
	
	public static class ListFloatingIps implements NovaCommand<FloatingIps>{

		@Override
		public FloatingIps execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-floating-ips");
		    request.header("Accept", "application/json");
		    return connector.execute(request, FloatingIps.class);
		}

	}

	public static class AllocateFloatingIp implements NovaCommand<FloatingIp> {
		
		private Map<String, String> body;
			
		public AllocateFloatingIp(String pool) {
			body = new HashMap<String, String>();
			if(pool != null) {
				body.put("pool", pool);
			}
		}

		@Override
		public FloatingIp execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-floating-ips");
		    request.header("Accept", "application/json");
		    return connector.execute(request, FloatingIp.class);
		}

	}
	
	public static class DeallocateFloatingIp implements NovaCommand<Void> {

		private String id;
		
		public DeallocateFloatingIp(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("DELETE");
		    request.path("/os-floating-ips/").path(id);
		    request.header("Accept", "application/json");
		    connector.execute(request);
			return null;
		}
		
	}

	
	public static class AssociateFloatingIp implements NovaCommand<Void> {
		
		private org.openstack.nova.model.ServerAction.AssociateFloatingIp action;

		private String id;
		
		public AssociateFloatingIp(String id, org.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    connector.execute(request);
			return null;
		}

	}
	
	public static class DisassociateFloatingIp implements NovaCommand<Void> {
		
		private org.openstack.nova.model.ServerAction.DisassociateFloatingIp action;

		private String id;
		
		public DisassociateFloatingIp(String id, org.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    connector.execute(request);
			return null;
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
