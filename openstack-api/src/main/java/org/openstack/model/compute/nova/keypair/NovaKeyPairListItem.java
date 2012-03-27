package org.openstack.model.compute.nova.keypair;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.openstack.model.compute.KeyPairListItem;

@XmlAccessorType(XmlAccessType.NONE)
public class NovaKeyPairListItem implements Serializable, KeyPairListItem {
	
	@XmlElement(name = "keypair")
	NovaKeyPair keypair;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.keypair.KeyPairListItem#getKeypair()
	 */
	@Override
	public NovaKeyPair getKeypair() {
		return keypair;
	}

	public void setKeypair(NovaKeyPair keypair) {
		this.keypair = keypair;
	}

	@Override
	public String toString() {
		return "KeyPairListItem [keypair=" + keypair + "]";
	}
	
}
