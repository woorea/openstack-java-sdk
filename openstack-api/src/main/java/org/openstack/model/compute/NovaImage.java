package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.atom.Link;
import org.openstack.model.common.JsonRootElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@XmlRootElement(name="image")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("image")
public class NovaImage implements Serializable {

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
	private NovaMetadata metadata;

	//RAX-DCF="http://docs.rackspacecloud.com/servers/api/ext/diskConfig/v1.0"
	
	@XmlElement(name="link", namespace="http://www.w3.org/2005/Atom")
	private List<Link> links;
	
	public NovaImage() {
		
	}

	public NovaImage(String id, String name) {
		this.id = id;
		this.name = name;
	}

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

	public NovaMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(NovaMetadata metadata) {
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
	
	public Link getLink(final String rel) {
		return Iterables.find(links, new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				return rel.equals(link.getRel());
			}
		});
	}
	
}
