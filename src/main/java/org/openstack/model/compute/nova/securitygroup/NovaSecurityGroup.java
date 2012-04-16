package org.openstack.model.compute.nova.securitygroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupRule;

@XmlRootElement(name = "security_group")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("security_group")
public class NovaSecurityGroup implements SecurityGroup, Serializable {

    @XmlAttribute
    protected Integer id;

    @XmlAttribute(name = "tenant_id")
    @JsonProperty("tenant_id")
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
    @JsonDeserialize(as=List.class, contentAs=NovaSecurityGroupRule.class)
    protected List<SecurityGroupRule> rules = new ArrayList<SecurityGroupRule>();

    public NovaSecurityGroup() {
		// TODO Auto-generated constructor stub
	}
    
    public NovaSecurityGroup(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getTenantId() {
		return tenantId;
	}

	@Override
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<SecurityGroupRule> getRules() {
		return rules;
	}

	@Override
	public void setRules(List<SecurityGroupRule> rules) {
		this.rules = rules;
	}

}
