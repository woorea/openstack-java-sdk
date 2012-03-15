package org.openstack.ui.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class OpenStackPlace extends Place {
	
	private String service;
	
	private String tenantId;
	
	private String place;
	
	public OpenStackPlace(String service, String tenantId, String place) {
		this.service = service;
		this.tenantId = tenantId;
		this.place = place == null ? "" : place;
	}

	public String getService() {
		return service;
	}

	public String getTenantId() {
		return tenantId;
	}
	
	public String getPlace() {
		return place;
	}

	@Prefix("os")
	public static class Tokenizer implements PlaceTokenizer<OpenStackPlace> {
        @Override
        public String getToken(OpenStackPlace place) {
            return place.service + ":" + place.tenantId + ":" + place.place;
        }

        @Override
        public OpenStackPlace getPlace(String token) {
        	String[] parts = token.split(":");
            return new OpenStackPlace(parts[0], parts[1], parts.length == 3 ? parts[2] : "");
        }
    }
	
}
