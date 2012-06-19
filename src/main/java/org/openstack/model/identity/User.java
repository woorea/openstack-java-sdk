package org.openstack.model.identity;

import java.util.List;
import java.util.Map;

public interface User extends UserForCreate {
	
	String getTenantId();

	List<Role> getRoles();
	
	Map<String, Object> getExtra();

}