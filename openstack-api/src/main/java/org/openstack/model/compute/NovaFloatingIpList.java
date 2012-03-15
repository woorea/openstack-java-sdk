package org.openstack.model.compute;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="floating_ips", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaFloatingIpList implements Iterable<NovaFloatingIp> {

	@XmlElementWrapper(name = "floating_ips")
    @XmlElement(name = "floating_ip")
	private List<NovaFloatingIp> list;

	public List<NovaFloatingIp> getList() {
		return list;
	}

	public void setList(List<NovaFloatingIp> list) {
		this.list = list;
	}

	@Override
	public Iterator<NovaFloatingIp> iterator() {
		return getList().iterator();
	}
	
}

