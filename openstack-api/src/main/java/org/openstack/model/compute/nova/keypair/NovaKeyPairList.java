package org.openstack.model.compute.nova.keypair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.KeyPairListItem;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "keypairs", namespace = "")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaKeyPairList implements Serializable, KeyPairList {

	@XmlElement(name = "keypair", namespace = "")
	@SerializedName("keypairs")
	private List<NovaKeyPairListItem> list = new ArrayList<NovaKeyPairListItem>();

	

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPairList#getList()
	 */
	@Override
	public List<KeyPairListItem> getList() {
		if (list == null)
			list = Lists.newArrayList();
		return (List<KeyPairListItem>) (List<?>) list;
	}

	@Override
	public String toString() {
		return "NovaKeyPairList [list=" + list + "]";
	}
}
