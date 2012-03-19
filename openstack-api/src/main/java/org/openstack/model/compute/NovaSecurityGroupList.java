package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "security_groups")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaSecurityGroupList implements Serializable, Iterable<NovaSecurityGroup> {

	@XmlElementWrapper(name = "security_groups")
	@XmlElement(name = "security_group")
	@SerializedName("security_groups")
	private List<NovaSecurityGroup> list = new ArrayList<NovaSecurityGroup>();

	public List<NovaSecurityGroup> getList() {
		if (list == null) {
			list = Lists.newArrayList();
		}
		return list;
	}

	@Override
	public Iterator<NovaSecurityGroup> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		return "NovaSecurityGroupList [list=" + list + "]";
	}

}
