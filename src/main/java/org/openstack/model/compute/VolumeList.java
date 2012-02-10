package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="volumes", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class VolumeList implements Serializable {

	@XmlElement(name="volume")
	private List<Volume> list = new ArrayList<Volume>();

	public List<Volume> getList() {
		return list;
	}

	public void setList(List<Volume> list) {
		this.list = list;
	}
	
}
