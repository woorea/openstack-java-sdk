package org.openstack.nova.api.extensions;

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
	
	public List listCloudpipes() {
		return new List();
	}
	
	public Create createCloudpipe(Cloudpipe cloudpipe) {
		return new Create(cloudpipe);
	}
	
	public static class List extends OpenStackRequest<Cloudpipes> {

		
		public List() {
		
			method(HttpMethod.GET);
		    path("/os-cloudpipes/");
		    header("Accept", "application/json");
		    returnType(Cloudpipes.class);
		}

	}

	public static class Create extends OpenStackRequest<Cloudpipe> {

		private Cloudpipe cloudpipe;
		
		public Create(Cloudpipe cloudpipe) {
			this.cloudpipe = cloudpipe;
			
			method(HttpMethod.POST);
		    path("/os-cloudpipes/");
		    header("Accept", "application/json");
		    json(cloudpipe);
		    returnType(Cloudpipe.class);
		}

	}

	
	
}
