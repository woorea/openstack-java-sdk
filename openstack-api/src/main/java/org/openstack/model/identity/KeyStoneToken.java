package org.openstack.model.identity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneToken implements Serializable {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String expires;

    @XmlElement
    private KeystoneTenant tenant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

	public KeystoneTenant getTenant() {
		return tenant;
	}

	public void setTenant(KeystoneTenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		return "KeyStoneToken [id=" + id + ", expires=" + expires + ", tenant="
				+ tenant + "]";
	}

    
}

