package org.openstack.model.identity;

import java.util.List;

public interface User extends UserForCreate {

	List<Role> getRoles();

}