package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.openstack.model.identity.ServiceEndpoint;

@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties({"publicURL2"})
public class KeystoneServiceEndpoint implements Serializable, ServiceEndpoint {

    @XmlAttribute
    private String region;

    @XmlAttribute
    private String tenantId;

    @XmlAttribute
    private String internalURL;

    @XmlAttribute
    private String publicURL;

    @XmlAttribute
    private String adminURL;

    @XmlAttribute
    private String versionId;
    
    @XmlAttribute
    private String versionInfo;

    @XmlAttribute
    private String versionList;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#getRegion()
	 */
    @Override
	public String getRegion() {
        return region;
    }

	public void setRegion(String region) {
        this.region = region;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#getTenantId()
	 */
    @Override
	public String getTenantId() {
        return tenantId;
    }

	public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#getInternalURL()
	 */
    @Override
	public String getInternalURL() {
        return internalURL;
    }

	public void setInternalURL(String internalURL) {
        this.internalURL = internalURL;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#getPublicURL()
	 */
    @Override
	public String getPublicURL() {
        return publicURL;
    }

	public void setPublicURL(String publicURL) {
        this.publicURL = publicURL;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#getAdminURL()
	 */
	@Override
	public String getAdminURL() {
		return adminURL;
	}

	public void setAdminURL(String adminURL) {
		this.adminURL = adminURL;
	}
	
	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public String getVersionList() {
		return versionList;
	}

	public void setVersionList(String versionList) {
		this.versionList = versionList;
	}

	@Override
	public String toString() {
		return "KeyStoneServiceEndpoint [region=" + region + ", tenantId="
				+ tenantId + ", internalURL=" + internalURL + ", publicURL="
				+ publicURL + ", adminURL=" + adminURL + ", versionId="
				+ versionId + ", versionList=" + versionList + "]";
	}
    
}
