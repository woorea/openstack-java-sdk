package org.openstack.model.compute;

public interface FloatingIp {

	Integer getId();

	String getIp();

	String getPool();

	String getInstanceId();

	String getFixedIp();

}