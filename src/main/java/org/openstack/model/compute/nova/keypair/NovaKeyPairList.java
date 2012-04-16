package org.openstack.model.compute.nova.keypair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.KeyPairListItem;

@XmlRootElement(name = "keypairs", namespace = "")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaKeyPairList implements Serializable, KeyPairList {

	@XmlElement(name = "keypair", namespace = "")
	@JsonProperty("keypairs")
	@JsonDeserialize(as=List.class, contentAs=NovaKeyPairListItem.class)
	private List<KeyPairListItem> list = new ArrayList<KeyPairListItem>();

	
	/* (non-Javadoc)
	 * @see org.openstack.model.compute.KeyPairList#getList()
	 */
	@Override
	public List<KeyPairListItem> getList() {
		return  list;
	}

	@Override
	public String toString() {
		return "NovaKeyPairList [list=" + list + "]";
	}
}
