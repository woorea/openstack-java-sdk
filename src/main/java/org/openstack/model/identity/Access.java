package org.openstack.model.identity;

import java.util.List;

import org.openstack.model.identity.keystone.ServiceCatalogEntry;

public interface Access {

	Token getToken();

	//void setToken(Token token);

	List<ServiceCatalogEntry> getServices();

	//void setServices(List<? extends Service> services);

	User getUser();

	public abstract ServiceEndpoint getEndpoint(final String type, final String region);

	//void setUser(User user);

}