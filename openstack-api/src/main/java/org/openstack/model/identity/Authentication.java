package org.openstack.model.identity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auth")
@XmlAccessorType(XmlAccessType.NONE)
public class Authentication implements Serializable {

    @XmlAccessorType(XmlAccessType.NONE)
    public static class PasswordCredentials {

        @XmlAttribute
        private String username;

        @XmlAttribute
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

    @XmlElement
    private PasswordCredentials passwordCredentials;

    @XmlAttribute()
    public String tenantName;

    // @XmlAttribute()
    // public String tenantId;

    public PasswordCredentials getPasswordCredentials() {
        return passwordCredentials;
    }

    public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
    }

}
