package org.openstack.model.compute;

public interface FloatingIp {

	String getId();

	String getIp();

	String getPool();

	String getInstanceId();

}