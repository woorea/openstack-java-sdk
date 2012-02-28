package org.openstack.model.identity;

public interface User {

	String getId();

	void setId(String id);

	String getName();

	void setName(String name);

	String getPassword();

	void setPassword(String password);

	String getEmail();

	void setEmail(String email);

	boolean isEnabled();

	void setEnabled(boolean enabled);

}