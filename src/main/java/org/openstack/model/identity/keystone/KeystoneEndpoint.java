package org.openstack.model.identity.keystone;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.identity.Endpoint;

@JsonRootName("endpoint")
public class KeystoneEndpoint implements Endpoint, Serializable {
	
	private String id;
	
	private String region;
	
	@JsonProperty("service_id")
	private String serviceId;
	
	@JsonProperty("publicurl")
	private String publicURL;
	
	@JsonProperty("adminurl")
	private String adminURL;
	
	@JsonProperty("internalurl")
	private String internalURL;
	
	public KeystoneEndpoint() {
		
	}
	
	public KeystoneEndpoint(String id, String region, String serviceId) {
		this.id = id;
		this.region = region;
		this.serviceId = serviceId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getRegion()
	 */
	@Override
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getServiceId()
	 */
	@Override
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getPublicURL()
	 */
	@Override
	public String getPublicURL() {
		return publicURL;
	}

	public void setPublicURL(String publicURL) {
		this.publicURL = publicURL;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getAdminURL()
	 */
	@Override
	public String getAdminURL() {
		return adminURL;
	}

	public void setAdminURL(String adminURL) {
		this.adminURL = adminURL;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getInternalURL()
	 */
	@Override
	public String getInternalURL() {
		return internalURL;
	}

	public void setInternalURL(String internalURL) {
		this.internalURL = internalURL;
	}

	@Override
	public String toString() {
		return "KeystoneEndpoint [region=" + region + ", serviceId="
				+ serviceId + ", publicURL=" + publicURL + ", adminURL="
				+ adminURL + ", internalURL=" + internalURL + "]";
	}
	
}
