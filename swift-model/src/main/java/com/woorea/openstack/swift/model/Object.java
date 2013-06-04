package com.woorea.openstack.swift.model;

import java.io.Serializable;
import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonProperty;


public class Object implements Serializable {
	
	private String subdir;
	
	private String name;
	
	private String hash;
	
	private int bytes;
	
	@JsonProperty("content_type")
	private String contentType;
	
	@JsonProperty("last_modified")
	private Calendar lastModified;

	/**
	 * @return the subdir
	 */
	public String getSubdir() {
		return subdir;
	}

	/**
	 * @param subdir the subdir to set
	 */
	public void setSubdir(String subdir) {
		this.subdir = subdir;
	}

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
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the bytes
	 */
	public int getBytes() {
		return bytes;
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the lastModified
	 */
	public Calendar getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}
	
}
