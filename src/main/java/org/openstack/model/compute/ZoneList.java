package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="zones", namespace="http://docs.rackspacecloud.com/servers/api/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class ZoneList implements Serializable {

	@XmlElement(name="zone", namespace="http://docs.rackspacecloud.com/servers/api/v1.0")
	private List<Zone> list = new ArrayList<Zone>();

	public List<Zone> getList() {
		return list;
	}

	public void setList(List<Zone> list) {
		this.list = list;
	}
	
}
