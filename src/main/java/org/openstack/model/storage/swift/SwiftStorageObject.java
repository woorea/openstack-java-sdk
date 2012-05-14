package org.openstack.model.storage.swift;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.storage.StorageObject;

@XmlRootElement(name = "object")
@XmlAccessorType(XmlAccessType.NONE)
public class SwiftStorageObject implements StorageObject {
	@XmlElement
	private String name;
	@XmlElement
	private String hash;

	@XmlElement
	private Long bytes;

	@XmlElement(name="content_type")
	@JsonProperty("content_type")
	private String contentType;

	@XmlElement(name = "last_modified")
	@JsonProperty("last_modified")
	private Date lastModified;
	
	private String subdir;

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObject#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObject#getHash()
	 */
	@Override
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObject#getBytes()
	 */
	@Override
	public Long getBytes() {
		return bytes;
	}

	public void setBytes(Long bytes) {
		this.bytes = bytes;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObject#getContentType()
	 */
	@Override
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.storage.swift.StorageObject#getLastModified()
	 */
	@Override
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getSubdir() {
		return subdir;
	}

	public void setSubdir(String subdir) {
		this.subdir = subdir;
	}

}
