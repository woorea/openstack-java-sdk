package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

@XmlRootElement(name="createBackup")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("createBackup")
public class CreateBackupAction implements Serializable, ServerAction {

	@XmlAttribute
	private String name;
	
	@XmlAttribute(name="backup_type")
	private String type;
	
	@XmlAttribute
	private String rotation;
	
	@XmlElement
	private Map<String, String> metadata;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRotation() {
		return rotation;
	}

	public void setRotation(String rotation) {
		this.rotation = rotation;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "CreateBackupAction [name=" + name + ", type=" + type
				+ ", rotation=" + rotation + ", metadata=" + metadata + "]";
	}
	
	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
}
