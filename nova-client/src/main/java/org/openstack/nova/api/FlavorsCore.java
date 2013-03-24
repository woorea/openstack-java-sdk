package org.openstack.nova.api;

import java.util.Map;

import org.openstack.base.client.OpenStackClientConnector;
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
		public Flavors execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path(detail ? "/flavors/detail" : "/flavors");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Flavors.class);
		}

	}
	
	public static class ShowFlavor implements NovaCommand<Flavor> {

		private String id;
		
		public ShowFlavor(String id) {
			this.id = id;
		}

		@Override
		public Flavor execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/flavors/").path(id);
		    request.header("Accept", "application/json");
		    return connector.execute(request, Flavor.class);
		}
		
	}

	
	public static class ShowFlavorMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowFlavorMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/flavors/").path(id).path("metadata");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Metadata.class).getMetadata();
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
