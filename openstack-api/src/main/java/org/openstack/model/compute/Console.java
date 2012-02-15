package org.openstack.model.compute;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class Console implements Serializable {

	@XmlAttribute
	private String id;
	
	@XmlAttribute(name="console_type")
	private String type;
	
	@XmlAttribute
	private String password;
	
	@XmlAttribute(name="instance_name")
	private String instanceName;
	
	@XmlAttribute(name="host")
	private String rxtxFactor;
	
	@XmlAttribute
	private int port;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getRxtxFactor() {
		return rxtxFactor;
	}

	public void setRxtxFactor(String rxtxFactor) {
		this.rxtxFactor = rxtxFactor;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Console [id=" + id + ", type=" + type + ", password="
				+ password + ", instanceName=" + instanceName + ", rxtxFactor="
				+ rxtxFactor + ", port=" + port + "]";
	}
	
}
