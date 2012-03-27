package org.openstack.model.identity;

public interface Token {

	String getId();

	//void setId(String id);

	String getExpires();

	//void setExpires(String expires);

	Tenant getTenant();

	//void setTenant(Tenant tenant);

}