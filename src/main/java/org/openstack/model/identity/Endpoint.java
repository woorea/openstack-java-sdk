package org.openstack.model.identity;

public interface Endpoint {

	String getId();
	
	void setId(String id);
	
	String getRegion();
	
	void setRegion(String region);

	String getServiceId();
	
	void setServiceId(String serviceId);

	String getPublicURL();
	
	void setPublicURL(String publicURL);

	String getAdminURL();
	
	void setAdminURL(String adminURL);

	String getInternalURL();
	
	void setInternalURL(String internalURL);

}