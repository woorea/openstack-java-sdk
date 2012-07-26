package org.openstack.ceilometer.collector.handlers;

import java.util.Set;

import org.openstack.ceilometer.model.MeterEvent;
import org.openstack.ceilometer.model.NotificationInfo;

public interface NotificationHandler {

	public Set<MeterEvent> handle(NotificationInfo notificationInfo);
	
	public boolean supports(NotificationInfo notificationInfo);
	
}
