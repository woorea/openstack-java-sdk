package org.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.FloatingIps;
import org.openstack.nova.model.FloatingIp;

public class FloatingIpsExtension {
	
	public static class ListFloatingIps implements NovaCommand<FloatingIps>{

		@Override
		public FloatingIps execute(WebTarget target) {
			return target.path("os-floating-ips").request(MediaType.APPLICATION_JSON).get(FloatingIps.class);
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
		public FloatingIp execute(WebTarget target) {
			return target.path("os-floating-ips").request(MediaType.APPLICATION_JSON).post(Entity.json(body)).readEntity(FloatingIp.class);
		}

	}
	
	public static class DeallocateFloatingIp implements NovaCommand<Void> {

		private String id;
		
		public DeallocateFloatingIp(String id) {
			this.id = id;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("os-floating-ips").path(id).request(MediaType.APPLICATION_JSON).delete();
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
		public Void execute(WebTarget target) {
			target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action));
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
		public Void execute(WebTarget target) {
			target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action));
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
