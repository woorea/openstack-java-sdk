package org.openstack.model.storage.swift;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.storage.StorageAccount;
import org.openstack.model.storage.StorageContainer;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.NONE)
public class SwiftAccount implements StorageAccount {
	
	@XmlElement(name="container")
	@JsonDeserialize(as=List.class, contentAs=SwiftContainer.class)
	private List<StorageContainer> containers = new ArrayList<StorageContainer>();

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.Account#getContainers()
	 */
	@Override
	public List<StorageContainer> getContainers() {
		return containers;
	}

	@Override
	public String toString() {
		return "SwiftAccount [containers=" + containers + "]";
	}
	
	
}
