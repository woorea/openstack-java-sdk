package org.openstack.model.compute;

public interface Console {

	String getId();

	String getType();

	String getPassword();

	String getInstanceName();

	String getRxtxFactor();

	int getPort();

}