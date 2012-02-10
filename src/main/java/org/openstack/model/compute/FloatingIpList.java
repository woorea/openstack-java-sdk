package org.openstack.model.compute;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="floating_ips", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class FloatingIpList {

	@XmlElement(name="floating_ips", namespace="")
	private List<FloatingIp> list;

	public List<FloatingIp> getList() {
		return list;
	}

	public void setList(List<FloatingIp> list) {
		this.list = list;
	}
	
}

