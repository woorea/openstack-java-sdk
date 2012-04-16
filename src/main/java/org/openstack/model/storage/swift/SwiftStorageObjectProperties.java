package org.openstack.model.storage.swift;

import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.storage.StorageObjectProperties;

import com.google.common.collect.Maps;

public class SwiftStorageObjectProperties implements StorageObjectProperties {
	private String name;

	private Date date;

	@JsonProperty("last-modified")
	private Date lastModified;

	@JsonProperty("content-length")
	private Long contentLength;

	@JsonProperty("etag")
	private String eTag;

	@JsonProperty("content-type")
	private String contentType;

	private Map<String, String> customProperties;

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getCustomProperties()
	 */
	@Override
	public Map<String, String> getCustomProperties() {
		if (customProperties == null) {
			customProperties = Maps.newHashMap();
		}
		return customProperties;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getDate()
	 */
	@Override
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getLastModified()
	 */
	@Override
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getContentLength()
	 */
	@Override
	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getETag()
	 */
	@Override
	public String getETag() {
		return eTag;
	}

	public void setETag(String eTag) {
		this.eTag = eTag;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getContentType()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObjectProperties#getLastModifiedDate()
	 */
	@Override
	public Date getLastModifiedDate() {
		return lastModified;
	}
	
}
