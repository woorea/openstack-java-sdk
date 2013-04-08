package org.openstack.nova.api;

import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.Flavors;
import org.openstack.nova.model.Metadata;

public class FlavorsCore {
	
	public static class ListFlavors implements NovaCommand<Flavors>{

		boolean detail;
		
		public ListFlavors(boolean detail) {
			this.detail = detail;
		}
		
		public ListFlavors() {
			this(false);
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path(detail ? "/flavors/detail" : "/flavors");
		    request.header("Accept", "application/json");
		    request.returnType(Flavors.class);
		return request;
		}

	}
	
	public static class ShowFlavor implements NovaCommand<Flavor> {

		private String id;
		
		public ShowFlavor(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/flavors/").path(id);
		    request.header("Accept", "application/json");
		    request.returnType(Flavor.class);
		return request;
		}
		
	}

	
	public static class ShowFlavorMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowFlavorMetadata(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
		    request.path("/flavors/").path(id).path("metadata");
		    request.header("Accept", "application/json");
		    request.returnType(Metadata.class);
		    return request;
		}
		
	}
	
	public static ListFlavors listFlavors(boolean detail) {
		return new ListFlavors(detail);
	}
	
	public static ListFlavors listFlavors() {
		return listFlavors(false);
	}
	
	public static ShowFlavor showFlavor(String id) {
		return new ShowFlavor(id);
	}
	
	public static ShowFlavorMetadata showFlavorMetadata() {
		return new ShowFlavorMetadata("");
	}

}
