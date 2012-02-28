package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import org.openstack.model.identity.ServiceEndpoint;

@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneServiceEndpoint implements Serializable, ServiceEndpoint {

	@XmlAttribute
    private String id;
	
    @XmlAttribute
    private String region;

    @XmlAttribute
    private String tenantId;

    @XmlAttribute
    private String internalURL;

    @XmlAttribute
    private String publicURL;

    @XmlAttribute
    private String publicURL2;

    @XmlAttribute
    private String adminURL;

    @XmlAttribute
    private String versionId;

    @XmlAttribute
    private String versionList;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#getRegion()
	 */
    @Override
	public String getRegion() {
        return region;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#setRegion(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#setTenantId(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#setInternalURL(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceEndpoint#setPublicURL(java.lang.String)
	 */
    @Override
	public void setPublicURL(String publicURL) {
        this.publicURL = publicURL;
    }

    // @XmlElement
    // private ServiceVersion version;

}
