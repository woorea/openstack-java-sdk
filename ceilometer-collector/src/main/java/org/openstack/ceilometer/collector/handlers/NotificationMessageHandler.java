package org.openstack.ceilometer.collector.handlers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.openstack.ceilometer.JacksonJsonContext;
import org.openstack.ceilometer.model.MeterEvent;
import org.openstack.ceilometer.model.NotificationInfo;

public class NotificationMessageHandler implements MessageHandler {
	
	private Set<NotificationHandler> handlers = new HashSet<NotificationHandler>();
	
	public void add(NotificationHandler notificationHandler) {
		handlers.add(notificationHandler);
	}

	@Override
	public Set<MeterEvent> handle(String message) {
	
		NotificationInfo notificationInfo = read(message);
		
		for(NotificationHandler handler : handlers) {
			if(handler.supports(notificationInfo)) {
				return handler.handle(notificationInfo);
			}
		}
		
		throw new RuntimeException("notification " + notificationInfo.getEventType() + " not supported");
		
	}

	public NotificationInfo read(String message) {
		try {
			return JacksonJsonContext.OBJECT_MAPPER.readValue(message, NotificationInfo.class);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	

}
