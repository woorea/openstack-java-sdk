package org.openstack.model.compute;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="floating_ip", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class FloatingIp implements Serializable {
	
	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String ip;
	
	@XmlAttribute
	private String pool;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

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
	
}
