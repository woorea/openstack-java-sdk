package org.openstack.ceilometer.collector.handlers;

import java.util.HashSet;
import java.util.Set;

import org.openstack.ceilometer.model.MeterEvent;
import org.openstack.ceilometer.model.NotificationInfo;

public class FloatingIpNotificationHandler implements NotificationHandler {

	private static final String NETWORK_FLOATING_IP = "network.floating_ip.";
	
	@Override
	public Set<MeterEvent> handle(NotificationInfo notificationInfo) {
		
		String action = notificationInfo.getEventType().substring(NETWORK_FLOATING_IP.length());
		
		Set<MeterEvent> events = new HashSet<MeterEvent>();
		
		MeterEvent m = new MeterEvent();
		m.setSource("?");
		m.setName("floating_ip");
		m.setUserId(notificationInfo.getUserId());
		m.setProjectId(notificationInfo.getProjectId());
		m.setResourceId((String) notificationInfo.getPayload().get("floating_ip"));
		m.setTimestamp(notificationInfo.getTimestamp());
		m.setType("delta");
		m.setVolume(1);
		m.setMetadata(null);
		
		events.add(m);
		
		return events;
	}

	@Override
	public boolean supports(NotificationInfo notificationInfo) {
		return notificationInfo.getEventType().startsWith(NETWORK_FLOATING_IP);
	}

}
