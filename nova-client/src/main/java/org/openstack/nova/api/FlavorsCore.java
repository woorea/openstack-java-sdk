package org.openstack.nova.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.Flavors;
import org.openstack.nova.model.Metadata;

public class FlavorsCore {
	
	public static class ListFlavors extends OpenStackRequest {
		
		public ListFlavors(boolean detail) {
			method(HttpMethod.GET);
		    path(detail ? "/flavors/detail" : "/flavors");
		    header("Accept", "application/json");
		    returnType(Flavors.class);
		}
		
		public ListFlavors() {
			this(false);
		}

	}
	
	public static class ShowFlavor extends OpenStackRequest {
		
		public ShowFlavor(String id) {
			method(HttpMethod.GET);
		    path("/flavors/").path(id);
		    header("Accept", "application/json");
		    returnType(Flavor.class);
		}
		
	}

	
	public static class ShowFlavorMetadata extends OpenStackRequest {
		
		public ShowFlavorMetadata(String id) {
			method(HttpMethod.GET);
		    path("/flavors/").path(id).path("metadata");
		    header("Accept", "application/json");
		    returnType(Metadata.class);
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
