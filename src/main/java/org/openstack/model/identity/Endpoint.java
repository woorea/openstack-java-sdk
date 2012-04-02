package org.openstack.model.identity;

public interface Endpoint {

	String getRegion();

	String getServiceId();

	String getPublicURL();

	String getAdminURL();

	String getInternalURL();

	public abstract String getId();

}