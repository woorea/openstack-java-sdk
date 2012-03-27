package org.openstack.model.compute.nova.floatingip;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.FloatingIp;

@XmlRootElement(name = "floating_ip", namespace = "")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaFloatingIp implements Serializable, FloatingIp {

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String ip;

	@XmlAttribute
	private String pool;

	@XmlAttribute(name = "instance_id")
	private String instanceId;

	@XmlAttribute(name = "fixed_ip")
	private String fixedIp;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.FloatingIp#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.FloatingIp#getIp()
	 */
	@Override
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.FloatingIp#getPool()
	 */
	@Override
	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	@Override
	public String toString() {
		return "FloatingIp [id=" + id + ", ip=" + ip + ", pool=" + pool + "]";
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.FloatingIp#getInstanceId()
	 */
	@Override
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

}
