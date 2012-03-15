package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneAccess implements Serializable {
    @XmlElement(nillable = true, name = "service")
    @XmlElementWrapper(name = "serviceCatalog")
    private List<KeyStoneService> serviceCatalog;

    
    @XmlElement
    private KeyStoneToken token;

    @XmlElement
    public KeyStoneUser user;

    public KeyStoneToken getToken() {
        return token;
    }

    public void setToken(KeyStoneToken token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Access [token=" + token + "]";
    }

    public List<KeyStoneService> getServiceCatalog() {
        if (serviceCatalog == null) {
            serviceCatalog = Lists.newArrayList();
        }
        return serviceCatalog;
    }

}
