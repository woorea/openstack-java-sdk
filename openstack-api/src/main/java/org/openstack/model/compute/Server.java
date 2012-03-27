package org.openstack.model.compute;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.openstack.model.atom.Link;

public interface Server {

	String getId();

	String getName();

	String getStatus();

	Date getUpdated();

	Date getCreated();

	String getHostId();

	String getUserId();

	String getTenantId();

	String getAccessIpV4();

	String getAccessIpV6();

	String getAdminPass();

	String getProgress();

	String getConfigDrive();

	String getKeyName();

	Image getImage();

	String getImageId();

	Flavor getFlavor();

	Fault getFault();

	Metadata getMetadata();

	AddressList getAddresses();

	Map<QName, String> getExtensionAttributes();

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
	String getUuid();

	List<Link> getLinks();

	Link getLink(final String rel);

}