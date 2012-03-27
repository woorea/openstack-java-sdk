package org.openstack.model.compute;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule;

public interface SecurityGroup {

	Integer getId();

	String getTenantId();

	@XmlAttribute(name = "name")
	String getName();

	String getDescription();

	List<NovaSecurityGroupRule> getRules();

}