package org.openstack.model.identity;

import java.util.List;


public interface ServiceCatalogEntry {

	String getName();

	String getType();

	List<ServiceEndpoint> getEndpoints();

	List<String> getEndpointsLinks();

}