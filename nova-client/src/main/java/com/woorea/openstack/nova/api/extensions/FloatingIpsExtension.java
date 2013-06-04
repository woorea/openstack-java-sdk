package com.woorea.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIp;
import com.woorea.openstack.nova.model.FloatingIps;

public class FloatingIpsExtension {
	
	private final OpenStackClient CLIENT;
	
	public FloatingIpsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public class List extends OpenStackRequest<FloatingIps> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-floating-ips", null, FloatingIps.class);
		}

	}

	public class Allocate extends OpenStackRequest<FloatingIp> {
		
		private Map<String, String> body;
			
		public Allocate(String pool) {
			super(CLIENT, HttpMethod.POST, "/os-floating-ips", null, FloatingIp.class);
			body = new HashMap<String, String>();
			if(pool != null) {
				body.put("pool", pool);
			}
			entity(body, "application/json");
		}

	}
	
	public class Deallocate extends OpenStackRequest<Void> {
		
		public Deallocate(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuffer("/os-floating-ips/").append(id).toString(), null, Void.class);
		}
		
	}

	public List list() {
		return new List();
	}
	
	public Allocate allocate(String pool) {
		return new Allocate(pool);
	}
	
	public Deallocate deallocate(String id) {
		return new Deallocate(id);
	}
	
	
	
}
