package org.openstack.model.compute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class NovaCreateFloatingIpResponse {
	@XmlElement(name = "floating_ip")
	private NovaFloatingIp floatingIp;

	public NovaFloatingIp getFloatingIp() {
		return floatingIp;
	}

	public void setFloatingIp(NovaFloatingIp floatingIp) {
		this.floatingIp = floatingIp;
	}

}
