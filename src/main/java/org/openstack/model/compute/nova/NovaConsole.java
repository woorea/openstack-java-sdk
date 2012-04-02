package org.openstack.model.compute.nova;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.Console;

@XmlRootElement(namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaConsole implements Serializable, Console {

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

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Console#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Console#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Console#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Console#getInstanceName()
	 */
	@Override
	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Console#getRxtxFactor()
	 */
	@Override
	public String getRxtxFactor() {
		return rxtxFactor;
	}

	public void setRxtxFactor(String rxtxFactor) {
		this.rxtxFactor = rxtxFactor;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Console#getPort()
	 */
	@Override
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
