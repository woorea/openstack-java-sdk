package org.openstack.ceilometer;


import org.openstack.ceilometer.model.MeterEvent;

public interface MessageListener {

	public void onMessage(String message);
	
}
