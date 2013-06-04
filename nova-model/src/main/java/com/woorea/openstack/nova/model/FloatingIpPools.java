package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.woorea.openstack.nova.model.FloatingIpPools.FloatingIpPool;

public class FloatingIpPools implements Iterable<FloatingIpPool>, Serializable {
	
	public static class FloatingIpPool implements Serializable {

		private String name;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "FloatingIpPool [name=" + name + "]";
		}
		
	}

	@JsonProperty("floating_ip_pools")
	private List<FloatingIpPool> list;

	/**
	 * @return the list
	 */
	public List<FloatingIpPool> getList() {
		return list;
	}
	
	@Override
	public Iterator<FloatingIpPool> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FloatingIpPools [list=" + list + "]";
	}

}
