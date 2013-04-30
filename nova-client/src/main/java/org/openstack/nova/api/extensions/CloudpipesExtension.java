package org.openstack.nova.api.extensions;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Cloudpipe;
import org.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
	
	private final OpenStackClient CLIENT;
	
	public CloudpipesExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(Cloudpipe cloudpipe) {
		return new Create(cloudpipe);
	}
	
	public class List extends OpenStackRequest<Cloudpipes> {

		
		public List() {
			super(CLIENT, HttpMethod.GET, "/os-cloudpipes", null, Cloudpipes.class);
		}

	}

	public class Create extends OpenStackRequest<Cloudpipe> {

		private Cloudpipe cloudpipe;
		
		public Create(Cloudpipe cloudpipe) {
			super(CLIENT, HttpMethod.POST, "/os-cloudpipes", Entity.json(cloudpipe), Cloudpipe.class);
			this.cloudpipe = cloudpipe;
		}

	}

	
	
}
