package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.atom.Link;

public interface Image {

	String getId();

	String getName();

	String getStatus();

	String getUpdated();

	String getCreated();

	int getMinDisk();

	int getProgress();

	Metadata getMetadata();

	List<Link> getLinks();

	Link getLink(final String rel);

}