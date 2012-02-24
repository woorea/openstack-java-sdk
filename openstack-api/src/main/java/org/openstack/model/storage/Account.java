package org.openstack.model.storage;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Account {
	@XmlElement(name="container")
	private List<Container> containers;

	public List<Container> getContainers() {
		if (containers == null) {
			containers = Lists.newArrayList();
		}
		return containers;
	}
}
