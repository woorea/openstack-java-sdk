package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="snapshots", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaSnapshotList implements Serializable {

	@XmlElement(name="snapshot")
	private List<NovaSnapshot> list = new ArrayList<NovaSnapshot>();

	public List<NovaSnapshot> getList() {
		return list;
	}

	public void setList(List<NovaSnapshot> list) {
		this.list = list;
	}
	
}
