package org.openstack.model.identity;

import java.util.List;


public interface User {

	String getId();

	String getName();

	String getPassword();

	String getEmail();

	boolean isEnabled();

	String getUsername();

	List<Role> getRoles();

}