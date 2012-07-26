package org.openstack.ceilometer.collector.handlers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.openstack.ceilometer.JacksonJsonContext;
import org.openstack.ceilometer.model.MeterEvent;

public class MeterEventMessageHandler implements MessageHandler {

	@Override
	public Set<MeterEvent> handle(String message) {
		try {
			Set<MeterEvent> events = new HashSet<MeterEvent>();
			events.add(JacksonJsonContext.OBJECT_MAPPER.readValue(message, MeterEvent.class));
			return events;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
