package org.openstack.model.compute;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openstack.model.atom.Link;
import org.openstack.model.compute.nova.NovaAddressList.Network;

public interface Server {

	String getId();

	String getName();

	String getStatus();

	Date getUpdated();

	Date getCreated();

	String getHostId();

	String getUserId();

	String getTenantId();

	String getAccessIPv4();

	String getAccessIPv6();

	String getAdminPass();

	String getProgress();

	String getConfigDrive();

	String getKeyName();

	Image getImage();

	String getImageId();

	Flavor getFlavor();

	Fault getFault();

	Map<String, String> getMetadata();

	Map<String, List<Network.Ip>> getAddresses();

	List<Link> getLinks();

	Link getLink(final String rel);
	
	public Map<String, String> getExtensions();

}