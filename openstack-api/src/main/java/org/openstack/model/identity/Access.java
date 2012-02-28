package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

public interface Access extends Serializable {
	
	public interface Token extends Serializable {

		String getId();

		void setId(String id);

		String getExpires();

		void setExpires(String expires);

		Tenant getTenant();

		void setTenant(Tenant tenant);

		List<Tenant> getTenants();

		void setTenants(List<Tenant> tenants);

	}

	Token getToken();

	void setToken(Token token);

	List<Service> getServiceCatalog();

}