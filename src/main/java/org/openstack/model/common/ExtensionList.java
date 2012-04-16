package org.openstack.model.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "extensions")
@XmlAccessorType(XmlAccessType.NONE)
public class ExtensionList implements Iterable<Extension> {

    @XmlElement(name = "extension")
    @JsonProperty("extensions")
    private List<Extension> list = new ArrayList<Extension>();

    public List<Extension> getList() {
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
