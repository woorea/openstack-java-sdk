package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;


public interface Service extends Serializable {

	String getId();

	void setId(String id);

	String getName();

	void setName(String name);

	String getType();

	void setType(String type);

	String getDescription();

	void setDescription(String description);

	List<ServiceEndpoint> getEndpoints();

}