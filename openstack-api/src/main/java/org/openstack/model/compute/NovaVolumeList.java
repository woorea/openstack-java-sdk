package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="volumes", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaVolumeList implements Serializable {

	@XmlElement(name="volume")
	private List<NovaVolume> list = new ArrayList<NovaVolume>();

	public List<NovaVolume> getList() {
		return list;
	}

	public void setList(List<NovaVolume> list) {
		this.list = list;
	}
	
}
