package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="keypairs", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyPairList implements Serializable {

	@XmlElement(name="keypair", namespace="")
	private List<KeyPair> list;

	public List<KeyPair> getList() {
		return list;
	}

	public void setList(List<KeyPair> list) {
		this.list = list;
	}
	
}
