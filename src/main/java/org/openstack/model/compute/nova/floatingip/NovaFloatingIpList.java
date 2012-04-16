package org.openstack.model.compute.nova.floatingip;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;

@XmlRootElement(name="floating_ips", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaFloatingIpList implements Serializable, FloatingIpList {

	@XmlElementWrapper(name = "floating_ips")
    @XmlElement(name = "floating_ip")
	@JsonProperty("floating_ips")
	@JsonDeserialize(as=List.class, contentAs=NovaFloatingIp.class)
	private List<FloatingIp> list;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.floatingip.FloatingIpList#getList()
	 */
	@Override
	public List<FloatingIp> getList() {
		return list;
	}

	public void setList(List<FloatingIp> list) {
		this.list = list;
	}
	
}

