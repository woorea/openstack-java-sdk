package org.openstack.model.compute;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "extensions")
@XmlAccessorType(XmlAccessType.NONE)
public class ExtensionList implements Iterable<Extension> {

    @XmlElement(name = "extension")
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
}
