package org.openstack.model.compute;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

@XmlRootElement(name = "keypairs", namespace = "")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyPairList implements Serializable, Iterable<KeyPair> {

	@XmlElementWrapper(name = "keypairs", namespace = "")
	@XmlElement(name = "keypair", namespace = "")
	private List<KeyPairListItem> list;

	@XmlAccessorType(XmlAccessType.NONE)
	public static class KeyPairListItem {
		@XmlElement(name = "keypair")
		KeyPair keypair;

		public KeyPair getKeypair() {
			return keypair;
		}

		public void setKeypair(KeyPair keypair) {
			this.keypair = keypair;
		}

	}

	public List<KeyPairListItem> getList() {
		if (list == null)
			list = Lists.newArrayList();
		return list;
	}

	@Override
	public Iterator<KeyPair> iterator() {
		return Iterators.transform(list.iterator(), new Function<KeyPairListItem, KeyPair>() {
			@Override
			public KeyPair apply(KeyPairListItem input) {
				return input.getKeypair();
			}
		});
	}
}
