package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import org.openstack.model.identity.Credentials;

public class KeystoneAccessKeyCredentials implements Credentials, Serializable {

    @XmlAttribute
    private String accessKey;

    @XmlAttribute
    private String secretKey;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

}
