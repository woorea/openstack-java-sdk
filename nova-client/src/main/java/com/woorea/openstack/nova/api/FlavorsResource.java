package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Flavor;
import com.woorea.openstack.nova.model.Flavors;
import com.woorea.openstack.nova.model.Metadata;

public class FlavorsResource {
	
	private final OpenStackClient CLIENT;
	
	public FlavorsResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(boolean detail) {
		return new List(detail);
	}
	
	public Create create(Flavor flavor) {
		return new Create(flavor);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}

	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Flavors> {
		
		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/flavors/detail" : "/flavors", null, Flavors.class);
		}

	}
	
	public class Create extends OpenStackRequest<Flavor> {

		private Flavor flavor;
		
		public Create(Flavor flavor) {
			super(CLIENT, HttpMethod.POST, "/flavors", Entity.json(flavor), Flavor.class);
			this.flavor = flavor;
		}
		
	}
	
	public class Show extends OpenStackRequest<Flavor> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/flavors/").append(id).toString(), null, Flavor.class);
		}

	}
	
	public class ShowMetadata extends OpenStackRequest<Metadata> {
		
		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/flavors/").append(id).append("/metadata").toString(), null, Metadata.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/flavors/").append(id).toString(), null, Void.class);
		}
		
	}
	
}

