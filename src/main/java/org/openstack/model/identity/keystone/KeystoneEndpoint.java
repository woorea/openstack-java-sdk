package org.openstack.model.identity.keystone;

import java.io.Serializable;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.identity.Endpoint;

import com.google.gson.annotations.SerializedName;

@JsonRootElement("endpoint")
public class KeystoneEndpoint implements Endpoint, Serializable {
	
	private String id;
	
	private String region;
	
	@SerializedName("service_id")
	private String serviceId;
	
	@SerializedName("publicurl")
	private String publicURL;
	
	@SerializedName("adminurl")
	private String adminURL;
	
	@SerializedName("internalurl")
	private String internalURL;

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
