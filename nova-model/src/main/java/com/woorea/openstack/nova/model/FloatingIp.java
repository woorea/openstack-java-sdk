package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("floating_ip")
public class FloatingIp implements Serializable {

	private String id;
	
	private String pool;
	
	private String ip;
	
	@JsonProperty("fixed_ip")
	private String fixedIp;
	
	@JsonProperty("instance_id")
	private String instanceId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the pool
	 */
	public String getPool() {
		return pool;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @return the fixedIp
	 */
	public String getFixedIp() {
		return fixedIp;
	}

	/**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FloatingIp [id=" + id + ", pool=" + pool + ", ip=" + ip
				+ ", fixedIp=" + fixedIp + ", instanceId=" + instanceId + "]";
	}
	
}
