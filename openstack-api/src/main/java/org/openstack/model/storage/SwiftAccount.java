package org.openstack.model.storage;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.NONE)
public class SwiftAccount {
	
	@XmlElement(name="container")
	private List<SwiftContainer> containers = new ArrayList<SwiftContainer>();

	public List<SwiftContainer> getContainers() {
		if (containers == null) {
			containers = Lists.newArrayList();
		}
		return containers;
	}

	@Override
	public String toString() {
		return "SwiftAccount [containers=" + containers + "]";
	}
	
	
}
