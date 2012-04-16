package org.openstack.model.compute.nova.snapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;

@XmlRootElement(name="snapshots", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaSnapshotList implements Serializable, SnapshotList {

	@XmlElement(name="snapshot")
	@JsonDeserialize(as=List.class, contentAs=NovaSnapshot.class)
	private List<Snapshot> snapshots = new ArrayList<Snapshot>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.SnapshotList#getList()
	 */
	@Override
	public List<Snapshot> getList() {
		return snapshots;
	}

	public void setList(List<Snapshot> snapshots) {
		this.snapshots = snapshots;
	}
	
}
