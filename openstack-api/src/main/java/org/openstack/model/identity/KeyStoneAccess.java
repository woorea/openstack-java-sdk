package org.openstack.model.identity;

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

import com.google.gson.annotations.SerializedName;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("access")
public class KeyStoneAccess implements Serializable {
    
    @XmlElement
    private KeyStoneToken token;
    
    @XmlElementWrapper(name = "serviceCatalog")
    @XmlElement(name = "service")
    @SerializedName("serviceCatalog")
	private List<KeyStoneService> services = new ArrayList<KeyStoneService>();

    @XmlElement
    private KeyStoneUser user;

    public KeyStoneToken getToken() {
        return token;
    }

    public void setToken(KeyStoneToken token) {
        this.token = token;
    }

	public List<KeyStoneService> getServices() {
		return services;
	}

	public void setServices(List<KeyStoneService> services) {
		this.services = services;
	}

	public KeyStoneUser getUser() {
		return user;
	}

	public void setUser(KeyStoneUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "KeyStoneAccess [token=" + token + ", services=" + services
				+ ", user=" + user + "]";
	}

}
