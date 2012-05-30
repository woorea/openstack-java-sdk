package org.openstack.model.identity.keystone;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("auth")
public class KeystonePasswordCredentialsAuthentication extends KeystoneAuthentication {
	
	@XmlElement(namespace= "", name="passwordCredentials")
    @JsonProperty
    private KeystonePasswordCredentials passwordCredentials;

	public KeystonePasswordCredentialsAuthentication(String username, String password) {
		passwordCredentials = new KeystonePasswordCredentials();
		passwordCredentials.setUsername(username);
		passwordCredentials.setPassword(password);
	}

	
	
}
