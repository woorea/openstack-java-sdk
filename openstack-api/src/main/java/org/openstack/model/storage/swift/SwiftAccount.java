package org.openstack.model.storage.swift;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.storage.StorageAccount;
import org.openstack.model.storage.StorageContainer;

import com.google.common.collect.Lists;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.NONE)
public class SwiftAccount implements StorageAccount {
	
	@XmlElement(name="container")
	private List<SwiftContainer> containers = new ArrayList<SwiftContainer>();

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.Account#getContainers()
	 */
	@Override
	public List<StorageContainer> getContainers() {
		if (containers == null) {
			containers = Lists.newArrayList();
		}
		return (List<StorageContainer>) (List<?>) containers;
	}

	@Override
	public String toString() {
		return "SwiftAccount [containers=" + containers + "]";
	}
	
	
}
