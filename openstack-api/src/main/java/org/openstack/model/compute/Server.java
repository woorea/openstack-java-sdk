package org.openstack.model.compute;

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

import org.openstack.client.common.ExtensionData;
import org.openstack.client.common.OpenstackSession;
import org.openstack.model.atom.Link;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Server implements Serializable {

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
	private String userId;

	@XmlAttribute
	private String tenantId;

	@XmlAttribute(name = "accessIPv4")
	private String accessIpV4;

	@XmlAttribute(name = "accessIPv6")
	private String accessIpV6;

	@XmlAnyAttribute
	private Map<QName, Object> extensionAttributes;

	@XmlAttribute
	private String adminPass;

	@XmlAttribute()
	private String progress;

	@XmlAttribute(name = "config_drive")
	private String configDrive;

	@XmlAttribute(name = "key_name")
	private String keyName;

	@XmlElement
	private Image image;

	@XmlElement
	private Flavor flavor;

	@XmlElement
	private Fault fault;

	@XmlElement
	private Metadata metadata;

	@XmlElement
	private Addresses addresses;

	@XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
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

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getAccessIpV4() {
		return accessIpV4;
	}

	public void setAccessIpV4(String accessIpV4) {
		this.accessIpV4 = accessIpV4;
	}

	public String getAccessIpV6() {
		return accessIpV6;
	}

	public void setAccessIpV6(String accessIpV6) {
		this.accessIpV6 = accessIpV6;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getConfigDrive() {
		return configDrive;
	}

	public void setConfigDrive(String configDrive) {
		this.configDrive = configDrive;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Image getImage(OpenstackSession session) {
		if (image.getName() == null) {
			image = Iterables.find(image.getLinks(), new Predicate<Link>() {
				@Override
				public boolean apply(Link link) {
					if("bookmark".equals(link.getRel())) {
						//dirty hack since urls are not correct in the XML
						//may this is fixed in the current revision
						//so simply comment this
						link.setHref(link.getHref().replace(":8774/", ":8774/v1.1/"));
						return true;
					} else {
						return false;
					}
				}

			}).follow(session, "GET", Image.class);
		}
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Flavor getFlavor(OpenstackSession session) {
		if (flavor.getName() == null) {
			flavor = Iterables.find(flavor.getLinks(), new Predicate<Link>() {

				@Override
				public boolean apply(Link link) {
					if("bookmark".equals(link.getRel())) {
						//dirty hack since urls are not correct in the XML
						//may this is fixed in the current revision
						//so simply comment this
						link.setHref(link.getHref().replace(":8774/", ":8774/v1.1/"));
						return true;
					} else {
						return false;
					}
				}

			}).follow(session, "GET", Flavor.class);
		}
		return flavor;
	}

	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

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

	public ExtensionData getExtensionData() {
		return new ExtensionData(extensionAttributes);
	}

}
