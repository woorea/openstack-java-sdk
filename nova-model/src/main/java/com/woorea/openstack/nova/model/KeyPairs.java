package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class KeyPairs implements Iterable<KeyPair>, Serializable {
	
	public static final class KeyPairWrapper implements Serializable {
		
		@JsonProperty
		private KeyPair keypair;
		
	}

	@JsonProperty("keypairs")
	private List<KeyPairWrapper> list;

	/**
	 * @return the list
	 */
	public List<KeyPair> getList() {
		List<KeyPair> list = new ArrayList<KeyPair>();
		for(KeyPairWrapper wrapper : this.list) {
			list.add(wrapper.keypair);
		}
		return list;
	}
	
	@Override
	public Iterator<KeyPair> iterator() {
		return getList().iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KeyPairs [list=" + getList() + "]";
	}

}
