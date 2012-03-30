package org.openstack.model.compute.nova.floatingip;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="floating_ips", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class NovaFloatingIpList implements Serializable, FloatingIpList {

	@XmlElementWrapper(name = "floating_ips")
    @XmlElement(name = "floating_ip")
	@SerializedName("floating_ips")
	private List<NovaFloatingIp> list;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.floatingip.FloatingIpList#getList()
	 */
	@Override
	public List<FloatingIp> getList() {
		return (List<FloatingIp>) (List<?>) list;
	}

	public void setList(List<NovaFloatingIp> list) {
		this.list = list;
	}
	
}

