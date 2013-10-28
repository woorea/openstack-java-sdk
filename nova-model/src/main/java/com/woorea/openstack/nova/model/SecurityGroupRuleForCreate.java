package com.woorea.openstack.nova.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("security_group_rule")
public class SecurityGroupRuleForCreate implements Serializable {

	@JsonProperty("parent_group_id")
	private String parentGroupId;
	
	@JsonProperty("ip_protocol")
	private String ipProtocol;

	@JsonProperty("from_port")
	private Integer fromPort;

	@JsonProperty("to_port")
	private Integer toPort;
	
	@XmlElement
	private String cidr;

	@JsonProperty("group_id")
	private String groupId;
	
	public SecurityGroupRuleForCreate() {
		
	}
	
	/**
	 * 
	 * @param parentSecurityGroupId
	 * @param ipProtocol
	 * @param fromPort
	 * @param toPort
	 * @param cidr
	 * @deprecated Ids in some installs have shown to use strings .Use {@link #SecurityGroupRuleForCreate(String, String, Integer, Integer, String)}
	 */
	@Deprecated
	public SecurityGroupRuleForCreate(Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,Integer toPort, String cidr) {
		this.parentGroupId = String.valueOf(parentSecurityGroupId);
		this.ipProtocol = ipProtocol;
		this.fromPort = fromPort;
		this.toPort = toPort;
		this.cidr = cidr;
	}
	/**
	 * 
	 * @param parentSecurityGroupId
	 * @param ipProtocol
	 * @param fromPort
	 * @param toPort
	 * @param cidr
	 * @deprecated Ids in some installs have shown to use strings .Use {@link #SecurityGroupRuleForCreate(String, String, String, Integer, Integer)}
	 */
	@Deprecated
	public SecurityGroupRuleForCreate(Integer parentGroupId, String ipProtocol, Integer fromPort,Integer toPort, Integer sourceGroupId) {
		this.parentGroupId = String.valueOf(parentGroupId);
		this.ipProtocol = ipProtocol;
		this.fromPort = fromPort;
		this.toPort = toPort;
		this.groupId = String.valueOf(sourceGroupId);
	}
	
	public SecurityGroupRuleForCreate(String parentSecurityGroupId, String ipProtocol, Integer fromPort,Integer toPort, String cidr) {
		this.parentGroupId = parentSecurityGroupId;
		this.ipProtocol = ipProtocol;
		this.fromPort = fromPort;
		this.toPort = toPort;
		this.cidr = cidr;
	}
	
	public SecurityGroupRuleForCreate(String parentGroupId, String sourceGroupId, String ipProtocol, Integer fromPort,Integer toPort) {
		this.parentGroupId = parentGroupId;
		this.ipProtocol = ipProtocol;
		this.fromPort = fromPort;
		this.toPort = toPort;
		this.groupId = sourceGroupId;
	}

	/**
	 * @return the parentGroupId
	 */
	public String getParentGroupId() {
		return parentGroupId;
	}
	
	
	/**
	 * @param parentGroupId the parentGroupId to set
	 * @deprecated Use {@link #setParentGroupId(String)}
	 */
	public void setParentGroupId(Integer parentGroupId) {
		this.parentGroupId = String.valueOf(parentGroupId);
	}
	
	/**
	 * @param parentGroupId the parentGroupId to set
	 */
	public void setParentGroupId(String parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	/**
	 * @return the fromPort
	 */
	public Integer getFromPort() {
		return fromPort;
	}

	/**
	 * @param fromPort the fromPort to set
	 */
	public void setFromPort(Integer fromPort) {
		this.fromPort = fromPort;
	}

	/**
	 * @return the toPort
	 */
	public Integer getToPort() {
		return toPort;
	}

	/**
	 * @param toPort the toPort to set
	 */
	public void setToPort(Integer toPort) {
		this.toPort = toPort;
	}

	/**
	 * @return the ipProtocol
	 */
	public String getIpProtocol() {
		return ipProtocol;
	}

	/**
	 * @param ipProtocol the ipProtocol to set
	 */
	public void setIpProtocol(String ipProtocol) {
		this.ipProtocol = ipProtocol;
	}

	/**
	 * @return the cidr
	 */
	public String getCidr() {
		return cidr;
	}

	/**
	 * @param cidr the cidr to set
	 */
	public void setCidr(String cidr) {
		this.cidr = cidr;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 * @deprecated Use {@link #setGroupId(String)}
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = String.valueOf(groupId);
	}
	
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityGroupRuleForCreate [parentGroupId=" + parentGroupId
				+ ", fromPort=" + fromPort + ", toPort=" + toPort
				+ ", ipProtocol=" + ipProtocol + ", cidr=" + cidr
				+ ", groupId=" + groupId + "]";
	}

}
