package org.openstack.model.compute.nova.floatingip;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.FloatingIp;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class NovaCreateFloatingIpResponse {
	@XmlElement(name = "floating_ip")
	private FloatingIp floatingIp;

	public FloatingIp getFloatingIp() {
		return floatingIp;
	}

	public void setFloatingIp(FloatingIp floatingIp) {
		this.floatingIp = floatingIp;
	}

}
