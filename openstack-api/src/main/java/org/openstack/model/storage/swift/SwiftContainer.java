package org.openstack.model.storage.swift;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.storage.StorageContainer;
import org.openstack.model.storage.StorageObject;

import com.google.common.collect.Lists;

@XmlRootElement(name = "container")
@XmlAccessorType(XmlAccessType.NONE)
public class SwiftContainer implements StorageContainer {
	@XmlElement
	private String name;

	@XmlElement
	private long count;

	@XmlElement
	private long bytes;

	@XmlElement(name = "object")
	private List<SwiftStorageObject> objects;

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.Container#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.Container#getCount()
	 */
	@Override
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.Container#getBytes()
	 */
	@Override
	public long getBytes() {
		return bytes;
	}

	public void setBytes(long bytes) {
		this.bytes = bytes;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.Container#getObjects()
	 */
	@Override
	public List<StorageObject> getObjects() {
		if (objects == null)
			objects = Lists.newArrayList();
		return (List<StorageObject>) (List<?>) objects;
	}

	@Override
	public String toString() {
		return "Container [name=" + name + ", count=" + count + ", bytes=" + bytes + ", objects=" + objects + "]";
	}

}
