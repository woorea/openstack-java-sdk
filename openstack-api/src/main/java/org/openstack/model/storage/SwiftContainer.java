package org.openstack.model.storage;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "container")
@XmlAccessorType(XmlAccessType.NONE)
public class SwiftContainer {
	@XmlElement
	private String name;

	@XmlElement
	private long count;

	@XmlElement
	private long bytes;

	@XmlElement(name = "object")
	private List<SwiftStorageObject> objects;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getBytes() {
		return bytes;
	}

	public void setBytes(long bytes) {
		this.bytes = bytes;
	}

	public List<SwiftStorageObject> getObjects() {
		if (objects == null)
			objects = Lists.newArrayList();
		return objects;
	}

	@Override
	public String toString() {
		return "Container [name=" + name + ", count=" + count + ", bytes=" + bytes + ", objects=" + objects + "]";
	}

}
