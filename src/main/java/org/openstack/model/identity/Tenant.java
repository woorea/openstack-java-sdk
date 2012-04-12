package org.openstack.model.identity;

public interface Tenant {

	String getId();

	void setId(String id);

	String getName();

	void setName(String name);

	boolean isEnabled();

	void setEnabled(boolean enabled);

	String getDescription();

	void setDescription(String description);

}