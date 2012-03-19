package org.openstack.model.identity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.api.common.Namespaces;
import org.openstack.model.common.JsonRootElement;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("access")
public class KeyStoneAccess implements Serializable {
    
    @XmlElement
    private KeyStoneToken token;
    
    @XmlElement
    private KeyStoneServiceCatalog serviceCatalog;

    @XmlElement
    private KeyStoneUser user;

    public KeyStoneToken getToken() {
        return token;
    }

    public void setToken(KeyStoneToken token) {
        this.token = token;
    }

	public KeyStoneServiceCatalog getServiceCatalog() {
		return serviceCatalog;
	}

	public void setServiceCatalog(KeyStoneServiceCatalog serviceCatalog) {
		this.serviceCatalog = serviceCatalog;
	}

	public KeyStoneUser getUser() {
		return user;
	}

	public void setUser(KeyStoneUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "KeyStoneAccess [token=" + token + ", serviceCatalog="
				+ serviceCatalog + ", user=" + user + "]";
	}

}
