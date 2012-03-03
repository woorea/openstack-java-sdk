package org.openstack.model.compute;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.atom.Link;

import com.google.common.collect.Lists;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Image implements Serializable {

	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String status;
	
	
	//2011-12-26T02:09:15Z
	@XmlAttribute
	private String updated;
	
	@XmlAttribute
	private String created;
	
	@XmlAttribute
	private int minDisk;
	
	@XmlAttribute
	private int progress;
	
	@XmlElement
	private ImageMetadata metadata;
	
	@XmlAccessorType(XmlAccessType.NONE)
	public static class ImageMetadata implements Serializable, Iterable<ImageMetadata.ImageMetadataItem> {

	    @XmlAccessorType(XmlAccessType.NONE)
	    public static final class ImageMetadataItem  {

	        @XmlAttribute
	        private String key;

	        @XmlValue
	        private String value;

	        public String getKey() {
	            return key;
	        }

	        public void setKey(String key) {
	            this.key = key;
	        }

	        public String getValue() {
	            return value;
	        }

	        public void setValue(String value) {
	            this.value = value;
	        }

	    }

	    @XmlElement(name = "meta")
	    private List<ImageMetadataItem> items;

	    public List<ImageMetadataItem> getItems() {
	    	if (items == null) {
	    		items = Lists.newArrayList();
	    	}
	        return items;
	    }

		@Override
		public Iterator<ImageMetadataItem> iterator() {
			return getItems().iterator();
		}
	}

	
	//RAX-DCF="http://docs.rackspacecloud.com/servers/api/ext/diskConfig/v1.0"
	
	@XmlElement(name="link", namespace="http://www.w3.org/2005/Atom")
	@JsonProperty("links")
	private List<Link> links;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getMinDisk() {
		return minDisk;
	}

	public void setMinDisk(int minDisk) {
		this.minDisk = minDisk;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public ImageMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(ImageMetadata metadata) {
		this.metadata = metadata;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", status=" + status
				+ ", updated=" + updated + ", created=" + created
				+ ", minDisk=" + minDisk + ", progress=" + progress
				+ ", metadata=" + metadata + ", links=" + links + "]";
	}
	
}
