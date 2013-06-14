package org.openstack.heat.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Resources implements Iterable<Resource>, Serializable{
	private static final long serialVersionUID = 8535374527228144691L;
	private List<Resource> resources;

	
	public List<Resource> getResources() {
		return resources;
	}

	@Override
	public Iterator<Resource> iterator() {
		return resources.iterator();
	}

	@Override
	public String toString() {
		return "resources:" + resources;
	}
}
