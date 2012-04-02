package org.openstack.model.compute;

public interface SecurityGroupRuleForCreate {

	Integer getParentGroupId();

	void setParentGroupId(Integer parentGroupId);

	Integer getFromPort();

	void setFromPort(Integer fromPort);

	Integer getToPort();

	void setToPort(Integer toPort);

	String getIpProtocol();

	void setIpProtocol(String ipProtocol);

	String getCidr();

	void setCidr(String cidr);

	Integer getGroupId();

	void setGroupId(Integer groupId);

}