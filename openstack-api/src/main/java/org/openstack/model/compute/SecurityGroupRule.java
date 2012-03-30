package org.openstack.model.compute;

import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule.Group;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule.IpRange;

public interface SecurityGroupRule {

	Integer getId();

	String getName();

	Integer getParentGroupId();

	Integer getFromPort();

	Integer getToPort();

	String getIpProtocol();

	IpRange getIpRange();

	Group getGroup();

}