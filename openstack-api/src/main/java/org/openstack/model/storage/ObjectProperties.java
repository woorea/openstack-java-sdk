package org.openstack.model.storage;

import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.collect.Maps;

public class ObjectProperties {
	private String name;

	@JsonProperty("date")
	private Date date;

	@JsonProperty("last-modified")
	private Date lastModified;

	@JsonProperty("content-length")
	private Long contentLength;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("content-type")
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

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
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
				+ ", contentLength=" + contentLength + ", etag=" + etag + ", contentType=" + contentType
				+ ", customProperties=" + customProperties + "]";
	}

}
