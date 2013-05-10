package org.openstack.ceilometer.v2.api;

import java.util.List;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Resource;

public class ResourcesResource {
	
	private final OpenStackClient CLIENT;
	
	public ResourcesResource(OpenStackClient client) {
		CLIENT = client;
	}

	public class ResourceList extends QueriableCeilometerCommand<ResourceList, List<Resource>> {
	
		public ResourceList() {
			OpenStackRequest request = new OpenStackRequest();
			//return query(target.path("resources")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Resource>>() {});
		}

	}
	
	public class ResourceShow extends OpenStackRequest {

		private String id;
			
		public ResourceShow id(String id) {
			this.id = id;
			return this;
		}
		
		public ResourceShow(OpenStackClient client) {
//			if(id == null) {
//				throw new UnsupportedOperationException("resource id is mandatory");
//			}
//			return target.path("resources").path(id).request(MediaType.APPLICATION_JSON).get(Resource.class);
		}

	}

}
