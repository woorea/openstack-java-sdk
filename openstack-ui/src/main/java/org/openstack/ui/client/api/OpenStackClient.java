package org.openstack.ui.client.api;

import java.util.List;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Tenant;

import com.google.gwt.core.client.GWT;

public class OpenStackClient {

	public static final IdentityServiceAsync IDENTITY = GWT.create(IdentityService.class);
	
	public static final ComputeServiceAsync COMPUTE = GWT.create(ComputeService.class);
	
	public static Access access;
	
	public static List<Tenant> tenants;
	
	public static String getToken() {
		return access.getToken().getId();
	}
	
	public static String getTenant() {
		GWT.log(""+access);
		return access.getToken().getTenant().getId();
	}
	
	public static List<Tenant> getTenants() {
		return tenants;
	}
	
	public static String getComputeURL() {
		//return session.getBestEndpoint("compute");
		return  "http://192.168.1.52:8774/v2/" + getTenant();
	}

	public static String getIdentityURL() {
		//return session.getBestEndpoint("identity");
		return "http://192.168.1.52:5000/v2.0";
	}
}
