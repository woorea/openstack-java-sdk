package org.openstack.model.identity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneToken implements Serializable {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String expires;

    @XmlElement
    private KeyStoneTenant tenant;

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

	public KeyStoneTenant getTenant() {
		return tenant;
	}

	public void setTenant(KeyStoneTenant tenant) {
		this.tenant = tenant;
	}

    @Override
    public String toString() {
        return "Token [id=" + id + ", expires=" + expires + "]";
    }
}

