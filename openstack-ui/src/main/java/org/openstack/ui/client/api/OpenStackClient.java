package org.openstack.ui.client.api;

import java.util.List;

import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.ServiceEndpoint;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.keystone.ServiceCatalogEntry;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.gwt.core.client.GWT;

public class OpenStackClient {

	public static final IdentityServiceAsync IDENTITY = GWT.create(IdentityService.class);
	
	public static final ComputeServiceAsync COMPUTE = GWT.create(ComputeService.class);
	
	public static String region;
	
	public static Access access;
	
	public static List<Tenant> tenants;
	
	public static String getToken() {
		return access.getToken().getId();
	}
	
	public static String getTenant() {
		return access.getToken().getTenant().getId();
	}
	
	public static List<Tenant> getTenants() {
		return tenants;
	}
	
	public static String getServiceURL(String type) {
		try {
			ServiceCatalogEntry service = Iterables.find(access.getServices(), new Predicate<ServiceCatalogEntry>() {

				@Override
				public boolean apply(ServiceCatalogEntry service) {
					return "compute".equals(service.getType());
				}
				
			});
			//TODO: always get the first one available
			return service.getEndpoints().get(0).getPublicURL();
		} catch (Exception e) {
			throw new OpenstackException(e.getMessage(), e);
		}
		
	}
}
