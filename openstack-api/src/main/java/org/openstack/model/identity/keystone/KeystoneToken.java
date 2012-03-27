package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.Token;

@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneToken implements Serializable, Token {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String expires;

    @XmlElement(type = KeystoneTenant.class)
    private KeystoneTenant tenant;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Token#getId()
	 */
    @Override
	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Token#getExpires()
	 */
    @Override
	public String getExpires() {
        return expires;
    }

	public void setExpires(String expires) {
        this.expires = expires;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Token#getTenant()
	 */
	@Override
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = (KeystoneTenant) tenant;
	}

	@Override
	public String toString() {
		return "KeyStoneToken [id=" + id + ", expires=" + expires + ", tenant="
				+ tenant + "]";
	}

    
}

