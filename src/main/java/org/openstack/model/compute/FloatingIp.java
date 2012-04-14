package org.openstack.model.compute;

public interface FloatingIp {

	Integer getId();
	
	void setId(Integer id);

	String getIp();
	
	void setIp(String ip);

	String getPool();
	
	void setPool(String pool);

	String getInstanceId();
	
	void setInstanceId(String instanceId);

	String getFixedIp();
	
	void setFixedIp(String fixedIp);

}