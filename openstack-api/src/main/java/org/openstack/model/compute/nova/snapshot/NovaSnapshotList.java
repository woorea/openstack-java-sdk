package org.openstack.model.compute.nova.snapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.common.ListWithAtomLinks;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;

@XmlRootElement(name="snapshots", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class NovaSnapshotList implements Serializable, SnapshotList {

	@XmlElement(name="snapshot")
	private List<NovaSnapshot> list = new ArrayList<NovaSnapshot>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.SnapshotList#getList()
	 */
	@Override
	public List<Snapshot> getList() {
		return (List<Snapshot>) (List<?>) list;
	}

	public void setList(List<NovaSnapshot> list) {
		this.list = list;
	}
	
}
