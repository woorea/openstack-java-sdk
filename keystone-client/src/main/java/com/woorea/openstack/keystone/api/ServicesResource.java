package com.woorea.openstack.keystone.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Service;
import com.woorea.openstack.keystone.model.Services;

public class ServicesResource {
	
	private OpenStackClient client;
	
	public ServicesResource(OpenStackClient client) {
		this.client = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(Service service) {
		return new Create(service);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Services> {
		
		public List() {
			super(client, HttpMethod.GET, "/OS-KSADM/services", null, Services.class);
		}

	}
	
	public class Create extends OpenStackRequest<Service> {

		private Service service;
		
		public Create(Service service) {
			super(client, HttpMethod.POST, "/OS-KSADM/services", Entity.json(service), Service.class);
			this.service = service;
		}
		
	}
	
	public class Show extends OpenStackRequest<Service> {
		
		public Show(String id) {
			super(client, HttpMethod.GET, new StringBuilder("/OS-KSADM/services/").append(id).toString(), null, Service.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(client, HttpMethod.DELETE, new StringBuilder("/OS-KSADM/services/").append(id).toString(), null, Void.class);
		}
		
	}
	
}
