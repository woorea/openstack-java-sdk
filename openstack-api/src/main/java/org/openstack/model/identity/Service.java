package org.openstack.model.identity;

import java.util.List;

public interface Service {

	String getId();

	//void setId(String id);

	String getName();

	//void setName(String name);

	String getType();

	//void setType(String type);

	String getDescription();

	//void setDescription(String description);

	List<ServiceEndpoint> getEndpoints();

}