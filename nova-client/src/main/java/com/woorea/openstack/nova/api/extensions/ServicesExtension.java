package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Service;
import com.woorea.openstack.nova.model.Services;

public class ServicesExtension {
	
	private final OpenStackClient CLIENT;
	
	public ServicesExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(boolean details) {
		return new List(details);
	}

	public Enable enable(String host, String binary) {
		return new Enable(host, binary);
	}

	public Disable disable(String host, String binary) {
		return new Disable(host, binary);
	}

	public class List extends OpenStackRequest<Services> {

		public List(boolean detailed) {
			super(CLIENT, HttpMethod.GET,
				"/os-services" + (detailed ? "/detail" : ""),
				null, Services.class);
		}

	}

	public class Enable extends OpenStackRequest<Service> {
		
		public Enable(String host, String binary) {
			super(CLIENT, HttpMethod.PUT, "/os-services/enable",
				Entity.json("{\"host\":\"" + host
					+ "\", \"binary\":\"" + binary + "\"}"),
				Service.class);
		}
	}
	
	public class Disable extends OpenStackRequest<Service> {
		
		public Disable(String host, String binary) {
			super(CLIENT, HttpMethod.PUT, "/os-services/disable",
				Entity.json("{\"host\":\"" + host
					+ "\", \"binary\":\"" + binary + "\"}"),
				Service.class);
		}
	}
}
