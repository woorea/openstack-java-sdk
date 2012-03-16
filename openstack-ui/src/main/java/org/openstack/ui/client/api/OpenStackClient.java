package org.openstack.ui.client.api;

import java.util.List;

import org.openstack.client.common.OpenStackSession;
import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneTenant;

import com.google.gwt.core.client.GWT;

public class OpenStackClient {

	public static final IdentityServiceAsync IDENTITY = GWT.create(IdentityService.class);
	
	public static final ComputeServiceAsync COMPUTE = GWT.create(ComputeService.class);
	
	public static OpenStackSessionData session;
	
	public static List<KeyStoneTenant> tenants;
	
	public static String getToken() {
		return session.getAccess().getToken().getId();
	}
	
	public static String getTenant() {
		return session.getAccess().getToken().getTenant().getId();
	}
	
	public static List<KeyStoneTenant> getTenants() {
		return tenants;
	}
	
	public static String getComputeURL() {
		return session.getBestEndpoint("compute");
		// return  "http://192.168.1.45:8774/v2/" + getTenant();
	}

	public static String getIdentityURL() {
		return session.getBestEndpoint("identity");
		// return "http://192.168.1.45:5000/v2.0";
	}
}
