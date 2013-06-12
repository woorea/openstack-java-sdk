package org.openstack.heat.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Events implements Iterable<Event>, Serializable{
	private static final long serialVersionUID = 2292730044135837499L;
	private List<Event> events;
	
	
	public List<Event> getEvents() {
		return events;
	}

	@Override
	public Iterator<Event> iterator() {
		return events.iterator();
	}

	@Override
	public String toString() {
		return "events:[" + events + "]";
	}

}
