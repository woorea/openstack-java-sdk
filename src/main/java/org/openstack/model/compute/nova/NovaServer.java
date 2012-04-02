package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import org.openstack.model.atom.Link;
import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.AddressList;
import org.openstack.model.compute.Fault;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Metadata;
import org.openstack.model.compute.Server;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("server")
public class NovaServer implements Serializable, Server {

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String name;

	@XmlAttribute
	private String status;

	@XmlAttribute
	private Date updated;

	@XmlAttribute
	private Date created;

	@XmlAttribute
	private String hostId;

	@XmlAttribute
	@SerializedName("user_id")
	private String userId;

	@XmlAttribute
	@SerializedName("tenant_id")
	private String tenantId;

	@XmlAttribute(name = "accessIPv4")
	private String accessIpV4;

	@XmlAttribute(name = "accessIPv6")
	private String accessIpV6;
	
	@XmlAnyAttribute
	private Map<QName, String> extensionAttributes;

	@XmlAttribute
	private String adminPass;

	@XmlAttribute()
	private String progress;

	@XmlAttribute(name = "config_drive")
	private String configDrive;

	@XmlAttribute(name = "key_name")
	private String keyName;

	@XmlElement(name = "image")
	private NovaImage image;

	@XmlElement(name = "flavor")
	private NovaFlavor flavor;

	@XmlElement(name = "fault")
	private NovaFault fault;

	@XmlElement(name = "metadata")
	private NovaMetadata metadata;

	@XmlElement(name = "addresses")
	private NovaAddressList addresses;

	@XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
	private List<Link> links;

	@XmlAttribute
	private String uuid;
	
	public NovaServer() {
		// TODO Auto-generated constructor stub
	}

	public NovaServer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getStatus()
	 */
	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getUpdated()
	 */
	@Override
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getCreated()
	 */
	@Override
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getHostId()
	 */
	@Override
	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getUserId()
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getTenantId()
	 */
	@Override
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getAccessIpV4()
	 */
	@Override
	public String getAccessIpV4() {
		return accessIpV4;
	}

	public void setAccessIpV4(String accessIpV4) {
		this.accessIpV4 = accessIpV4;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getAccessIpV6()
	 */
	@Override
	public String getAccessIpV6() {
		return accessIpV6;
	}

	public void setAccessIpV6(String accessIpV6) {
		this.accessIpV6 = accessIpV6;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getAdminPass()
	 */
	@Override
	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getProgress()
	 */
	@Override
	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getConfigDrive()
	 */
	@Override
	public String getConfigDrive() {
		return configDrive;
	}

	public void setConfigDrive(String configDrive) {
		this.configDrive = configDrive;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getKeyName()
	 */
	@Override
	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getImage()
	 */
	@Override
	public Image getImage() {
		return image;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getImageId()
	 */
	@Override
	public String getImageId() {
		if (image != null) {
			return image.getId();
		}
		return null;
	}

	public void setImage(NovaImage image) {
		this.image = image;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getFlavor()
	 */
	@Override
	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(NovaFlavor flavor) {
		this.flavor = flavor;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getFault()
	 */
	@Override
	public Fault getFault() {
		return fault;
	}

	public void setFault(NovaFault fault) {
		this.fault = fault;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getMetadata()
	 */
	@Override
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(NovaMetadata metadata) {
		this.metadata = metadata;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getAddresses()
	 */
	@Override
	public AddressList getAddresses() {
		return addresses;
	}

	public void setAddresses(NovaAddressList addresses) {
		this.addresses = addresses;
	}
	
	
	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getExtensionAttributes()
	 */
	@Override
	public Map<QName, String> getExtensionAttributes() {
		return extensionAttributes;
	}

	public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
		this.extensionAttributes = extensionAttributes;
	}

	/*
	@XmlAnyAttribute
	public Map<QName, String> getExtensionAttributes() {
		Map<QName, String> transform = new HashMap<QName, String>();
		for(Map.Entry<String, String> entry : extensionAttributes.entrySet()) {
			
		}
		return transform;
	}

	public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
		Map<String, String> transform = new HashMap<String, String>();
		for(Map.Entry<QName, String> entry : extensionAttributes.entrySet()) {
			
		}
		this.extensionAttributes = transform;
	}
	*/
	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getUuid()
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getLinks()
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
		return "Server [id=" + id + ", name=" + name + ", status=" + status + ", updated=" + updated + ", created="
				+ created + ", hostId=" + hostId + ", userId=" + userId + ", tenantId=" + tenantId + ", accessIpV4="
				+ accessIpV4 + ", accessIpV6=" + accessIpV6 + ", adminPass=" + adminPass + ", progress=" + progress
				+ ", configDrive=" + configDrive + ", keyName=" + keyName + ", image=" + image + ", flavor=" + flavor
				+ ", fault=" + fault + ", metadata=" + metadata + ", addresses=" + addresses + ", links=" + links + "]";
	}
	
	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Server#getLink(java.lang.String)
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
