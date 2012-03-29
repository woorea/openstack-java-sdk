package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.openstack.api.Namespaces;
import org.openstack.model.common.JsonRootElement;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.Token;
import org.openstack.model.identity.User;

import com.google.gson.annotations.SerializedName;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("access")
public class KeystoneAccess implements Serializable, Access {
    
    @XmlElement(type = KeystoneToken.class)
    private KeystoneToken token;
    
    @XmlElementWrapper(name = "serviceCatalog")
    @XmlElement(name = "service", type = KeystoneService.class)
    @SerializedName("serviceCatalog")
	private List<KeystoneServiceCatalogEntry> services = new ArrayList<KeystoneServiceCatalogEntry>();

    @XmlElement(type = KeystoneUser.class)
    private KeystoneUser user;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getToken()
	 */
    @Override
	public Token getToken() {
        return token;
    }

	public void setToken(KeystoneToken token) {
        this.token = (KeystoneToken) token;
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getServices()
	 */
	@Override
	public List<ServiceCatalogEntry> getServices() {
		return (List<ServiceCatalogEntry>) (List<?>) services;
	}

	public void setServices(List<KeystoneServiceCatalogEntry> services) {
		this.services = services;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.glance.Access#getUser()
	 */
	@Override
	public User getUser() {
		return user;
	}

	public void setUser(KeystoneUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "KeyStoneAccess [token=" + token + ", services=" + services
				+ ", user=" + user + "]";
	}

}
