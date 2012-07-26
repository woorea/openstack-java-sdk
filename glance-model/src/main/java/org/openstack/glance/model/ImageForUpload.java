package org.openstack.glance.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageForUpload {
	
	private String name;

	private String id;
	
	private String store;

	//aki, ari, ami, raw, iso, vhd, vdi, qcow2, or vmdk
	private String diskFormat;

	//aki, ari, ami, bare, or ovf
	private String containerFormat;
	
	private Integer size;
	
	private String checksum;

	private boolean isPublic;
	
	private String owner;
	
	private Map<String, Object> properties;
	
	private InputStream inputStream;

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
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the store
	 */
	public String getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(String store) {
		this.store = store;
	}

	/**
	 * @return the diskFormat
	 */
	public String getDiskFormat() {
		return diskFormat;
	}

	/**
	 * @param diskFormat the diskFormat to set
	 */
	public void setDiskFormat(String diskFormat) {
		this.diskFormat = diskFormat;
	}

	/**
	 * @return the containerFormat
	 */
	public String getContainerFormat() {
		return containerFormat;
	}

	/**
	 * @param containerFormat the containerFormat to set
	 */
	public void setContainerFormat(String containerFormat) {
		this.containerFormat = containerFormat;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}

	/**
	 * @param checksum the checksum to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/**
	 * @return the isPublic
	 */
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * @param isPublic the isPublic to set
	 */
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the properties
	 */
	public Map<String, Object> getProperties() {
		if(properties == null) {
			properties = new HashMap<String, Object>();
		}
		return properties;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
