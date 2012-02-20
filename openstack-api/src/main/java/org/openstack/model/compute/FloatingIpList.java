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
public class FloatingIpList implements Iterable<FloatingIp> {

	@XmlElementWrapper(name = "floating_ips")
    @XmlElement(name = "floating_ip")
	private List<FloatingIp> list;

	public List<FloatingIp> getList() {
		return list;
	}

	public void setList(List<FloatingIp> list) {
		this.list = list;
	}

	@Override
	public Iterator<FloatingIp> iterator() {
		return getList().iterator();
	}
	
}

