package org.openstack.model.identity;

import java.util.List;

public interface Access {

	Token getToken();

	//void setToken(Token token);

	List<? extends Service> getServices();

	//void setServices(List<? extends Service> services);

	User getUser();

	//void setUser(User user);

}