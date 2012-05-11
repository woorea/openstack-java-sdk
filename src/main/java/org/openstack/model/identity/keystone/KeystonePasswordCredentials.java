package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import org.openstack.model.identity.Credentials;

public class KeystonePasswordCredentials implements Credentials, Serializable {

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