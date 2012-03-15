package org.openstack.model.compute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "keypair")
public class NovaCreateKeyPairResponse {
	@XmlElement(name = "keypair")
	NovaKeyPair keypair;

	public NovaKeyPair getKeyPair() {
		return keypair;
	}

	public void setKeyPair(NovaKeyPair keypair) {
		this.keypair = keypair;
	}
}
