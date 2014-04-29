package com.woorea.openstack.ceilometer.v2.api;

import java.util.List;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.ceilometer.QueriableCeilometerCommand;
import com.woorea.openstack.ceilometer.v2.model.Resource;

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
	
	public class ResourceShow extends OpenStackRequest<Void> {

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
