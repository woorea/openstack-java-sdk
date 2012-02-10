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
public class SnapshotList implements Serializable {

	@XmlElement(name="snapshot")
	private List<Snapshot> list = new ArrayList<Snapshot>();

	public List<Snapshot> getList() {
		return list;
	}

	public void setList(List<Snapshot> list) {
		this.list = list;
	}
	
}
