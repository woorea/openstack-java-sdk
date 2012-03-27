package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.atom.Link;
import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Metadata;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@XmlRootElement(name="image")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("image")
public class NovaImage implements Serializable, Image {

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

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getStatus()
	 */
	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getUpdated()
	 */
	@Override
	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getCreated()
	 */
	@Override
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getMinDisk()
	 */
	@Override
	public int getMinDisk() {
		return minDisk;
	}

	public void setMinDisk(int minDisk) {
		this.minDisk = minDisk;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getProgress()
	 */
	@Override
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getMetadata()
	 */
	@Override
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(NovaMetadata metadata) {
		this.metadata = metadata;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getLinks()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Image#getLink(java.lang.String)
	 */
	@Override
	public Link getLink(final String rel) {
		return Iterables.find(links, new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				return rel.equals(link.getRel());
			}
		});
	}
	
}
