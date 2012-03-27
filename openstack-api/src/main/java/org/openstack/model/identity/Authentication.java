package org.openstack.model.identity;

import org.openstack.model.identity.keystone.KeystoneAuthentication;
import org.openstack.model.identity.keystone.KeystoneAuthentication.PasswordCredentials;

public interface Authentication {

	Token getToken();

	//void setToken(Token token);

	PasswordCredentials getPasswordCredentials();

	//void setPasswordCredentials(PasswordCredentials passwordCredentials);

	String getTenantId();

	//void setTenantId(String tenantId);

	String getTenantName();

	//void setTenantName(String tenantName);

}