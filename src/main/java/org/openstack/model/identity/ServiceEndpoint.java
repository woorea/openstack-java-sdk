package org.openstack.model.identity;

public interface ServiceEndpoint {

	String getRegion();

	//void setRegion(String region);

	String getTenantId();

	//void setTenantId(String tenantId);

	String getInternalURL();

	//void setInternalURL(String internalURL);

	String getPublicURL();

	//void setPublicURL(String publicURL);

	String getAdminURL();

	//void setAdminURL(String adminURL);

}