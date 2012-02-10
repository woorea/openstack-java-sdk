package org.openstack.model.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.openstack.model.compute.server.Personality.Item;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Metadata implements Serializable {

	@XmlAccessorType(XmlAccessType.NONE)
	public static final class Item implements Serializable {
		
		@XmlAttribute
		private String key;
		
		@XmlAttribute
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
	
	@XmlElement(name="item")
	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
