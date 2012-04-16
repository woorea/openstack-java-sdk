package org.openstack.model.compute.nova.keypair;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.KeyPair;

// TODO: Rename to KeyPairInfo?

@XmlRootElement(name="keypair", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("keypair")
public class NovaKeyPair implements Serializable, KeyPair {
	
	@XmlElement(required=true, namespace="")
	private String name;
	
	@XmlElement(name="public_key", namespace="")
	@JsonProperty("public_key")
	private String publicKey;
	
	@XmlElement(namespace="")
	private String fingerprint;

	@XmlElement(name="user_id")
	@JsonProperty("user_id")
	private String userId;
	
	@XmlElement(name="private_key")
	@JsonProperty("private_key")
	private String privateKey;
	
	public NovaKeyPair() {
		// TODO Auto-generated constructor stub
	}
	
	public NovaKeyPair(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPair#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPair#getPublicKey()
	 */
	@Override
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPair#getFingerprint()
	 */
	@Override
	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPair#getUserId()
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "KeyPair [name=" + name + ", publicKey=" + publicKey
				+ ", fingerprint=" + fingerprint + "]";
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPair#getPrivateKey()
	 */
	@Override
	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
}
