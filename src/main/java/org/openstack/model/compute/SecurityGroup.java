package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="security_group")
@XmlAccessorType(XmlAccessType.NONE)
public class SecurityGroup implements Serializable {
	
	@XmlAttribute
	private int id;
	
	@XmlAttribute(name="tenant_id")
	private String tenantId;
	
	@XmlAttribute
	private String name;
	
	@XmlElement
	private String description;
	
	@XmlElementWrapper(name="rules")
	@XmlElement(name="rule")
	private List<SecurityGroupRule> rules;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SecurityGroupRule> getRules() {
		return rules;
	}

	public void setRules(List<SecurityGroupRule> rules) {
		this.rules = rules;
	}

	@Override
	public String toString() {
		return "SecurityGroup [id=" + id + ", tenantId=" + tenantId + ", name="
				+ name + ", description=" + description + ", rules=" + rules
				+ "]";
	}
	
}
