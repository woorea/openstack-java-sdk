package org.openstack.model.identity;

public interface Endpoint {

	String getId();

	//void setId(String id);

	String getRegion();

	//void setRegion(String region);

	String getName();

	//void setName(String name);

	String getType();

	//void setType(String type);

	String getPublicUrl();

	//void setPublicUrl(String publicUrl);

	String getInternalUrl();

	//void setInternalUrl(String internalUrl);

	String getAdminURL();

	//void setAdminURL(String adminURL);

	boolean isEnabled();

	//void setEnabled(boolean enabled);

	boolean isGlobal();

	//void setGlobal(boolean global);

}