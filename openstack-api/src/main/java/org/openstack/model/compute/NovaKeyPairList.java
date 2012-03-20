package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "keypairs", namespace = "")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaKeyPairList implements Serializable, Iterable<NovaKeyPair> {

	@XmlElement(name = "keypair", namespace = "")
	@SerializedName("keypairs")
	private List<KeyPairListItem> list = new ArrayList<NovaKeyPairList.KeyPairListItem>();

	@XmlAccessorType(XmlAccessType.NONE)
	public static class KeyPairListItem implements Serializable {
		@XmlElement(name = "keypair")
		NovaKeyPair keypair;

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

	public List<KeyPairListItem> getList() {
		if (list == null)
			list = Lists.newArrayList();
		return list;
	}

	@Override
	public Iterator<NovaKeyPair> iterator() {
		return Iterators.transform(list.iterator(), new Function<KeyPairListItem, NovaKeyPair>() {
			@Override
			public NovaKeyPair apply(KeyPairListItem input) {
				return input.getKeypair();
			}
		});
	}

	@Override
	public String toString() {
		return "NovaKeyPairList [list=" + list + "]";
	}
}
