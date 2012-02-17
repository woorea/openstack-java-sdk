package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "access")
@XmlAccessorType(XmlAccessType.NONE)
public class Access implements Serializable {
    @XmlElement(nillable = true, name = "service")
    @XmlElementWrapper(name = "serviceCatalog")
    private List<Service> serviceCatalog;

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Token implements Serializable {

        @XmlAttribute
        private String id;

        @XmlAttribute
        private String expires;

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

        @Override
        public String toString() {
            return "Token [id=" + id + ", expires=" + expires + "]";
        }

    }

    @XmlElement
    private Token token;

    @XmlElement
    public User user;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Access [token=" + token + "]";
    }

    public List<Service> getServiceCatalog() {
        if (serviceCatalog == null) {
            serviceCatalog = Lists.newArrayList();
        }
        return serviceCatalog;
    }

}
