package org.openstack.model.compute;

public interface Fault {

	int getCode();

	String getCreated();

	String getMessage();

	String getDetails();

}