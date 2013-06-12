package org.openstack.heat.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Stacks implements Iterable<Stack>, Serializable{
	private static final long serialVersionUID = 4326257588956065394L;
	@JsonProperty("stacks")
	private List<Stack> stacks;
	
	
	public List<Stack> getStacks() {
		return stacks;
	}

	@Override
	public Iterator<Stack> iterator() {
		return stacks.iterator();
	}

	@Override
	public String toString() {
		return "stacks:" + stacks;
	}
}
