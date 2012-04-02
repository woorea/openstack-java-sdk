package org.openstack.model.common;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "extensions")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class ExtensionList implements Iterable<Extension> {

    @XmlElement(name = "extension")
    @SerializedName("extensions")
    private List<Extension> list;

    public List<Extension> getList() {
        if (list == null) {
            list = Lists.newArrayList();
        }
        return list;
    }

    @Override
    public Iterator<Extension> iterator() {
        return list.iterator();
    }

	@Override
	public String toString() {
		return "ExtensionList [list=" + list + "]";
	}
}
