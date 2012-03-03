package org.openstack.model.identity;

import java.io.Serializable;

public interface ServiceEndpoint extends Serializable {

	String getRegion();

	void setRegion(String region);

	String getTenantId();

	void setTenantId(String tenantId);

	String getInternalURL();

	void setInternalURL(String internalURL);

	String getPublicURL();

	void setPublicURL(String publicURL);

}