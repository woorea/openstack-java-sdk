package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("security_group")
public class SecurityGroup implements Serializable {
	
	@JsonRootName("security_group_rule")
	public static final class Rule implements Serializable {
	
	    public static final class Group implements Serializable {

	        private String name;

	        @JsonProperty("tenant_id")
	        private String tenantId;

	        public String getName() {
	            return name;
	        }
	        
	        public String getTenantId() {
	            return tenantId;
	        }

	        @Override
	        public String toString() {
	            return "Group [name=" + name + ", tenantId=" + tenantId + "]";
	        }

	    }

	    public static final class IpRange implements Serializable {

	        private String cidr;

	        public String getCidr() {
	            return cidr;
	        }

	        @Override
	        public String toString() {
	            return "IpRange [cidr=" + cidr + "]";
	        }

	    }

	    private String id;

	    private String name;

	    @JsonProperty("parent_group_id")
	    private String parentGroupId;

	    @JsonProperty("from_port")
	    private Integer fromPort;

	    @JsonProperty("to_port")
	    private Integer toPort;

	    @JsonProperty("ip_protocol")
	    private String ipProtocol;

	    @JsonProperty("ip_range")
	    private IpRange ipRange = new IpRange();

	    private Group group;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the parentGroupId
		 */
		public String getParentGroupId() {
			return parentGroupId;
		}

		/**
		 * @return the fromPort
		 */
		public Integer getFromPort() {
			return fromPort;
		}

		/**
		 * @return the toPort
		 */
		public Integer getToPort() {
			return toPort;
		}

		/**
		 * @return the ipProtocol
		 */
		public String getIpProtocol() {
			return ipProtocol;
		}

		/**
		 * @return the ipRange
		 */
		public IpRange getIpRange() {
			return ipRange;
		}

		/**
		 * @return the group
		 */
		public Group getGroup() {
			return group;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Rule [id=" + id + ", name=" + name + ", parentGroupId="
					+ parentGroupId + ", fromPort=" + fromPort + ", toPort="
					+ toPort + ", ipProtocol=" + ipProtocol + ", ipRange="
					+ ipRange + ", group=" + group + "]";
		}
		
	}

	private String id;
	
	private String name;
	
	private String description;
	
	@JsonProperty("tenant_id")
	private String tenantId;
	
	private List<Rule> rules;
	
	private List<Link> links;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @return the rules
	 */
	public List<Rule> getRules() {
		return rules;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityGroup [id=" + id + ", name=" + name + ", description="
				+ description + ", tenantId=" + tenantId + ", rules=" + rules
				+ ", links=" + links + "]";
	}
	
}
