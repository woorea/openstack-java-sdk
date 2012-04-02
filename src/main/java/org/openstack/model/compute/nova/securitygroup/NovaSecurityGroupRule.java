package org.openstack.model.compute.nova.securitygroup;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.SecurityGroupRule;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "security_group_rule")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("security_group_rule")
public class NovaSecurityGroupRule implements SecurityGroupRule, Serializable {

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
    private Integer id;

    @XmlAttribute
    private String name;

    @XmlElement(name = "parent_group_id", required = true)
    @SerializedName("parent_group_id")
    private Integer parentGroupId;

    @XmlElement(name = "from_port")
    @SerializedName("from_port")
    private Integer fromPort;

    @XmlElement(name = "to_port")
    @SerializedName("to_port")
    private Integer toPort;

    @XmlElement(name = "ip_protocol")
    @SerializedName("ip_protocol")
    private String ipProtocol;

    @XmlElement(name = "ip_range")
    @SerializedName("ip_range")
    private IpRange ipRange;

    @XmlElement
    private Group group;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getParentGroupId() {
		return parentGroupId;
	}

	@Override
	public void setParentGroupId(Integer parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	@Override
	public Integer getFromPort() {
		return fromPort;
	}

	@Override
	public void setFromPort(Integer fromPort) {
		this.fromPort = fromPort;
	}

	@Override
	public Integer getToPort() {
		return toPort;
	}

	@Override
	public void setToPort(Integer toPort) {
		this.toPort = toPort;
	}

	@Override
	public String getIpProtocol() {
		return ipProtocol;
	}

	@Override
	public void setIpProtocol(String ipProtocol) {
		this.ipProtocol = ipProtocol;
	}

	@Override
	public IpRange getIpRange() {
		return ipRange;
	}

	@Override
	public void setIpRange(IpRange ipRange) {
		this.ipRange = ipRange;
	}

	@Override
	public Group getGroup() {
		return group;
	}

	@Override
	public void setGroup(Group group) {
		this.group = group;
	}

}
