package org.openstack.model.storage;

import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

public class SwiftObjectProperties {
	private String name;

	private Date date;

	@SerializedName("last-modified")
	private Date lastModified;

	@SerializedName("content-length")
	private Long contentLength;

	@SerializedName("etag")
	private String eTag;

	@SerializedName("content-type")
	private String contentType;

	private Map<String, String> customProperties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getCustomProperties() {
		if (customProperties == null) {
			customProperties = Maps.newHashMap();
		}
		return customProperties;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public String getETag() {
		return eTag;
	}

	public void setETag(String eTag) {
		this.eTag = eTag;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setCustomProperties(Map<String, String> customProperties) {
		this.customProperties = customProperties;
	}

	@Override
	public String toString() {
		return "ObjectProperties [name=" + name + ", date=" + date + ", lastModified=" + lastModified
				+ ", contentLength=" + contentLength + ", etag=" + eTag + ", contentType=" + contentType
				+ ", customProperties=" + customProperties + "]";
	}

	public Date getLastModifiedDate() {
		return lastModified;
	}
	
}
