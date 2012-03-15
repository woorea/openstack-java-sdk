package org.openstack.model.compute;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "security_group_rule")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaSecurityGroupRule implements Serializable {

    @XmlAccessorType(XmlAccessType.NONE)
    public static final class Group implements Serializable {

        @XmlElement
        private String name;

        @XmlElement(name = "tenant_id")
        private String tenantId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        @Override
        public String toString() {
            return "Group [name=" + name + ", tenantId=" + tenantId + "]";
        }

    }

    @XmlAccessorType(XmlAccessType.NONE)
    public static final class IpRange implements Serializable {

        @XmlElement
        public String cidr;

        public String getCidr() {
            return cidr;
        }

        public void setCidr(String cidr) {
            this.cidr = cidr;
        }

        @Override
        public String toString() {
            return "IpRange [cidr=" + cidr + "]";
        }

    }

    @XmlAttribute
    public String id;

    @XmlAttribute
    public String name;

    @XmlElement(name = "parent_group_id", required = true)
    private Integer parentGroupId;

    @XmlElement(name = "from_port")
    public Integer fromPort;

    @XmlElement(name = "to_port")
    public Integer toPort;

    @XmlElement(name = "ip_protocol")
    public String ipProtocol;

    @XmlElement(name = "ip_range")
    public IpRange ipRange;

    @XmlElement(name = "group")
    private Group group;

    public Integer getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Integer parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public Integer getFromPort() {
        return fromPort;
    }

    public void setFromPort(Integer fromPort) {
        this.fromPort = fromPort;
    }

    public Integer getToPort() {
        return toPort;
    }

    public void setToPort(Integer toPort) {
        this.toPort = toPort;
    }

    public String getIpProtocol() {
        return ipProtocol;
    }

    public void setIpProtocol(String ipProtocol) {
        this.ipProtocol = ipProtocol;
    }

    public IpRange getIpRange() {
        return ipRange;
    }

    public void setIpRange(IpRange ipRange) {
        this.ipRange = ipRange;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "SecurityGroupRule [parentGroupId=" + parentGroupId + ", fromPort=" + fromPort + ", toPort=" + toPort + ", ipProtocol=" + ipProtocol + ", ipRange=" + ipRange + ", group=" + group + "]";
    }

}
