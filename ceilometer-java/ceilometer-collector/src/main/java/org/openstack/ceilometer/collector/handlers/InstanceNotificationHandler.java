package org.openstack.ceilometer.collector.handlers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.openstack.ceilometer.model.MeterEvent;
import org.openstack.ceilometer.model.NotificationInfo;

public class InstanceNotificationHandler implements NotificationHandler {

	private static final String COMPUTE_INSTANCE = "compute.instance.";
	
	@Override
	public Set<MeterEvent> handle(NotificationInfo notificationInfo) {
		
		String action = notificationInfo.getEventType().substring(COMPUTE_INSTANCE.length());
		
		Set<MeterEvent> events = new HashSet<MeterEvent>();
		
		MeterEvent m = new MeterEvent();
		m.setSource("?");
		m.setName("instance");
		m.setUserId(notificationInfo.getUserId());
		m.setProjectId(notificationInfo.getProjectId());
		m.setResourceId((String) notificationInfo.getPayload().get("instance_id"));
		m.setTimestamp(notificationInfo.getTimestamp());
		m.setType("cumulative");
		m.setVolume(1);
		m.setDuration(0);
		m.setMetadata(new HashMap<String, Object>());
		
		events.add(m);
		
		m = new MeterEvent();
		m.setSource("?");
		m.setName("memory");
		m.setUserId(notificationInfo.getUserId());
		m.setProjectId(notificationInfo.getProjectId());
		m.setResourceId((String) notificationInfo.getPayload().get("instance_id"));
		m.setTimestamp(notificationInfo.getTimestamp());
		m.setType("absolute");
		m.setDuration(0);
		m.setVolume((Number) notificationInfo.getPayload().get("memory_mb"));
		m.setMetadata(new HashMap<String, Object>());
		
		events.add(m);
		
		m = new MeterEvent();
		m.setSource("?");
		m.setName("vcpus");
		m.setUserId(notificationInfo.getUserId());
		m.setProjectId(notificationInfo.getProjectId());
		m.setResourceId((String) notificationInfo.getPayload().get("instance_id"));
		m.setTimestamp(notificationInfo.getTimestamp());
		m.setType("absolute");
		m.setDuration(0);
		m.setVolume((Number) notificationInfo.getPayload().get("vcpus"));
		m.setMetadata(new HashMap<String, Object>());
		
		events.add(m);
		
		m = new MeterEvent();
		m.setSource("?");
		m.setName("root_disk_size");
		m.setUserId(notificationInfo.getUserId());
		m.setProjectId(notificationInfo.getProjectId());
		m.setResourceId((String) notificationInfo.getPayload().get("instance_id"));
		m.setTimestamp(notificationInfo.getTimestamp());
		m.setType("absolute");
		m.setDuration(0);
		m.setVolume((Number) notificationInfo.getPayload().get("root_gb"));
		m.setMetadata(new HashMap<String, Object>());
		
		events.add(m);
		
		m = new MeterEvent();
		m.setSource("?");
		m.setName("ephemeral_disk_size");
		m.setUserId(notificationInfo.getUserId());
		m.setProjectId(notificationInfo.getProjectId());
		m.setResourceId((String) notificationInfo.getPayload().get("instance_id"));
		m.setTimestamp(notificationInfo.getTimestamp());
		m.setType("absolute");
		m.setDuration(0);
		m.setVolume((Number) notificationInfo.getPayload().get("ephemeral_gb"));
		m.setMetadata(new HashMap<String, Object>());
		
		events.add(m);
		
		return events;
		
	}

	@Override
	public boolean supports(NotificationInfo notificationInfo) {
		return notificationInfo.getEventType().startsWith(COMPUTE_INSTANCE);
	}

	

}
