package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.google.common.collect.Lists;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class NovaMetadata implements Serializable, Iterable<NovaMetadata.Item> {

    @XmlAccessorType(XmlAccessType.NONE)
    public static final class Item implements Serializable {

        @XmlAttribute
        private String key;

        @XmlValue
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Item() {

        }

        public Item(String key, String value) {
            super();
            this.key = key;
            this.value = value;
        }

    }

    @XmlElement(name = "item")
    private List<Item> items;

    public List<Item> getItems() {
    	if (items == null) {
    		items = Lists.newArrayList();
    	}
        return items;
    }

	@Override
	public Iterator<Item> iterator() {
		return getItems().iterator();
	}

}
