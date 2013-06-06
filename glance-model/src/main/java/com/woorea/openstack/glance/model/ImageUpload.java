package com.woorea.openstack.glance.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageUpload {

	private Image image;

	private String store;

	private Map<String, Object> properties;

	private InputStream inputStream;

	public ImageUpload(Image image) {
		setImage(image);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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
