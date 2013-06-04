package com.woorea.openstack.swift.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class Container implements Serializable {
	
	private String name;
	
	@JsonProperty("count")
	private Integer objectCount;
	
	@JsonProperty("bytes")
	private Long bytesUsed;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the objectCount
	 */
	public Integer getObjectCount() {
		return objectCount;
	}

	/**
	 * @param objectCount the objectCount to set
	 */
	public void setObjectCount(Integer objectCount) {
		this.objectCount = objectCount;
	}

	/**
	 * @return the bytesUsed
	 */
	public Long getBytesUsed() {
		return bytesUsed;
	}

	/**
	 * @param bytesUsed the bytesUsed to set
	 */
	public void setBytesUsed(Long bytesUsed) {
		this.bytesUsed = bytesUsed;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Container [name=" + name + ", objectCount=" + objectCount
				+ ", bytesUsed=" + bytesUsed + "]";
	}

	
	
}
