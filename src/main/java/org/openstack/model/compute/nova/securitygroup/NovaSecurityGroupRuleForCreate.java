package org.openstack.model.compute.nova.securitygroup;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.SecurityGroupRuleForCreate;

@XmlRootElement(name = "security_group_rule")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("security_group_rule")
public class NovaSecurityGroupRuleForCreate implements Serializable, SecurityGroupRuleForCreate {
		
		@XmlElement(name="parent_group_id", required=true)
		@JsonProperty("parent_group_id")
		private Integer parentGroupId;
		
		@XmlElement(name="from_port")
		@JsonProperty("from_port")
		private Integer fromPort;
		
		@XmlElement(name="to_port")
		@JsonProperty("to_port")
		private Integer toPort;
		
		@XmlElement(name="ip_protocol")
		@JsonProperty("ip_protocol")
		private String ipProtocol;
		
		@XmlElement
		private String cidr;
		
		@XmlElement(name="group_id")
		@JsonProperty("group_id")
		private Integer groupId;

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#getParentGroupId()
		 */
		@Override
		public Integer getParentGroupId() {
			return parentGroupId;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#setParentGroupId(java.lang.Integer)
		 */
		@Override
		public void setParentGroupId(Integer parentGroupId) {
			this.parentGroupId = parentGroupId;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#getFromPort()
		 */
		@Override
		public Integer getFromPort() {
			return fromPort;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#setFromPort(java.lang.Integer)
		 */
		@Override
		public void setFromPort(Integer fromPort) {
			this.fromPort = fromPort;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#getToPort()
		 */
		@Override
		public Integer getToPort() {
			return toPort;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#setToPort(java.lang.Integer)
		 */
		@Override
		public void setToPort(Integer toPort) {
			this.toPort = toPort;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#getIpProtocol()
		 */
		@Override
		public String getIpProtocol() {
			return ipProtocol;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#setIpProtocol(java.lang.String)
		 */
		@Override
		public void setIpProtocol(String ipProtocol) {
			this.ipProtocol = ipProtocol;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#getCidr()
		 */
		@Override
		public String getCidr() {
			return cidr;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#setCidr(java.lang.String)
		 */
		@Override
		public void setCidr(String cidr) {
			this.cidr = cidr;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#getGroupId()
		 */
		@Override
		public Integer getGroupId() {
			return groupId;
		}

		/* (non-Javadoc)
		 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupRuleForCreate#setGroupId(java.lang.Integer)
		 */
		@Override
		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}

		@Override
		public String toString() {
			return "SecurityGroupRule [parentGroupId=" + parentGroupId
					+ ", fromPort=" + fromPort + ", toPort=" + toPort
					+ ", ipProtocol=" + ipProtocol + ", cidr=" + cidr
					+ ", groupId=" + groupId + "]";
		}
	
}
