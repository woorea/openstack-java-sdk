package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Cloudpipe;
import org.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
	
	public static class ListCloudpipes extends OpenStackRequest {

		
		public ListCloudpipes() {
		
			method(HttpMethod.GET);
		    path("/os-cloudpipes/");
		    header("Accept", "application/json");
		    returnType(Cloudpipes.class);
		}

	}

	public static class CreateCloudpipe extends OpenStackRequest {

		private Cloudpipe cloudpipe;
		
		public CreateCloudpipe(Cloudpipe cloudpipe) {
			this.cloudpipe = cloudpipe;
			
			method(HttpMethod.POST);
		    path("/os-cloudpipes/");
		    header("Accept", "application/json");
		    json(cloudpipe);
		    returnType(Cloudpipe.class);
		}

	}

	public static ListCloudpipes listCloudpipes() {
		return new ListCloudpipes();
	}
	
	public static CreateCloudpipe createCloudpipe(Cloudpipe cloudpipe) {
		return new CreateCloudpipe(cloudpipe);
	}
	
}
