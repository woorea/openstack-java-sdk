package org.openstack.model.compute.nova.keypair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.KeyPair;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "keypair")
public class NovaCreateKeyPairResponse {
	@XmlElement(name = "keypair")
	KeyPair keypair;

	public KeyPair getKeyPair() {
		return keypair;
	}

	public void setKeyPair(KeyPair keypair) {
		this.keypair = keypair;
	}
}
