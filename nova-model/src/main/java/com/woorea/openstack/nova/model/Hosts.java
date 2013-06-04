package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hosts implements Iterable<Hosts.Host>, Serializable {
	
	public static final class Host {
		
		@JsonProperty("host_name")
		private String hostName;
		
		private String service;

		/**
		 * @return the hostName
		 */
		public String getHostName() {
			return hostName;
		}

		/**
		 * @return the service
		 */
		public String getService() {
			return service;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Host [hostName=" + hostName + ", service=" + service + "]";
		}
		
	}

	@JsonProperty("hosts")
	private List<Host> list;

	/**
	 * @return the list
	 */
	public List<Host> getList() {
		return list;
	}
	
	@Override
	public Iterator<Hosts.Host> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hosts [list=" + list + "]";
	}

	
	
}
