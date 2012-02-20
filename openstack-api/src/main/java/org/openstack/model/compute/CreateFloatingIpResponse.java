package org.openstack.model.compute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class CreateFloatingIpResponse {
	@XmlElement(name = "floating_ip")
	private FloatingIp floatingIp;

	public FloatingIp getFloatingIp() {
		return floatingIp;
	}

	public void setFloatingIp(FloatingIp floatingIp) {
		this.floatingIp = floatingIp;
	}

}
