package org.openstack.model.identity.keystone;

import java.util.List;

import org.openstack.model.identity.ServiceEndpoint;

public interface ServiceCatalogEntry {

	String getName();

	String getType();

	List<ServiceEndpoint> getEndpoints();

	List<String> getEndpointsLinks();

}