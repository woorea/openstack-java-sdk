package org.openstack.model.compute;

import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule.Group;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule.IpRange;

public interface SecurityGroupRule {

	public abstract void setGroup(Group group);

	public abstract Group getGroup();

	public abstract void setIpRange(IpRange ipRange);

	public abstract IpRange getIpRange();

	public abstract void setIpProtocol(String ipProtocol);

	public abstract String getIpProtocol();

	public abstract void setToPort(Integer toPort);

	public abstract Integer getToPort();

	public abstract void setFromPort(Integer fromPort);

	public abstract Integer getFromPort();

	public abstract void setParentGroupId(Integer parentGroupId);

	public abstract Integer getParentGroupId();

	public abstract void setName(String name);

	public abstract String getName();

	public abstract void setId(Integer id);

	public abstract Integer getId();

}
