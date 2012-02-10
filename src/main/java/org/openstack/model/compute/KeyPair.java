package org.openstack.model.compute;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="keypair", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyPair implements Serializable {
	
	@XmlElement(required=true, namespace="")
	private String name;
	
	@XmlElement(name="public_key", namespace="")
	private String publicKey;
	
	@XmlElement(namespace="")
	private String fingerprint;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	@Override
	public String toString() {
		return "KeyPair [name=" + name + ", publicKey=" + publicKey
				+ ", fingerprint=" + fingerprint + "]";
	}
	
}
