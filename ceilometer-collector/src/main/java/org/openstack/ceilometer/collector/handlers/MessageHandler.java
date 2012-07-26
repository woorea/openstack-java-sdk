package org.openstack.ceilometer.collector.handlers;

import java.util.Set;

import org.openstack.ceilometer.model.MeterEvent;


public interface MessageHandler {

	public Set<MeterEvent> handle(String message);
	
}
