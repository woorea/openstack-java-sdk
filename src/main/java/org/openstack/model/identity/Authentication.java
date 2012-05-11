package org.openstack.model.identity;

public interface Authentication {

	Token getToken();

	//void setToken(Token token);

	Credentials getCredentials();

	//void setPasswordCredentials(PasswordCredentials passwordCredentials);

	String getTenantId();

	//void setTenantId(String tenantId);

	String getTenantName();

	//void setTenantName(String tenantName);

}