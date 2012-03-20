package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;

@XmlRootElement(name = "security_group")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("security_group")
public class NovaSecurityGroup implements Serializable {

    @XmlAttribute
    protected Integer id;

    @XmlAttribute(name = "tenant_id")
    protected String tenantId;

    // The name shifts from being an element to being an attribute; sigh
    // I think it's an element when we're creating a server, and an attribute when we're creating a group
    // We pass both (the same) and accept either.
    // TODO: Get this fixed
    protected String name;

    @XmlElement
    protected String description;

    @XmlElementWrapper(name = "rules")
    @XmlElement(name = "rule")
    protected List<NovaSecurityGroupRule> rules;

    public NovaSecurityGroup() {
		// TODO Auto-generated constructor stub
	}
    
    public NovaSecurityGroup(int id, String name) {
		this.id = id;
		this.name = name;
	}

	

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @XmlAttribute(name = "name")
    public String getName() {
    	/*
        if (nameAttribute == null) {
            return nameElement;
        }
        if (nameElement == null) {
            return nameAttribute;
        }
        if (!nameElement.equals(nameAttribute))
            throw new IllegalStateException();
        return nameElement;
        */
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
    	/*
        this.nameAttribute = name;
        this.nameElement = name;
        */
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NovaSecurityGroupRule> getRules() {
        return rules;
    }

    public void setRules(List<NovaSecurityGroupRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "SecurityGroup [id=" + id + ", tenantId=" + tenantId + ", name=" + name + ", description=" + description + ", rules=" + rules + "]";
    }

}
